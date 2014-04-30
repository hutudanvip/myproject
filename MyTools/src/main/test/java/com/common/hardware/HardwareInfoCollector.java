package com.common.hardware;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.StringTokenizer;
import org.apache.log4j.Logger;

public class HardwareInfoCollector implements IHardwareInfoCollector {

	public static IHardwareInfoCollector getCollector() {
		if (collector == null)
			collector = new HardwareInfoCollector();
		return collector;
	}

	private HardwareInfoCollector() {
		dllName = "HardwareInfoCollector.dll";
		String clientRoot = System.getProperty("easclient.root");
		String dllFullPath = "E:/DPAP/workspaces2/myproject/MyTools/src/main/test/java/com/common/hardware/HardwareInfoCollector.dll";
//		if (clientRoot.endsWith(File.separator))
//			dllFullPath = clientRoot + dllName;
//		else
//			dllFullPath = clientRoot + File.separator + dllName;
		System.load(dllFullPath);
	}

	public native String getHardDriverID();

	public native String getCPUID();

	public String getMACAddress() {
		String os = System.getProperty("os.name");
		String macAddress = "mac_error";
		try {
			if (os.startsWith("Windows"))
				macAddress = windowsParseMacAddress(windowsRunIpConfigCommand());
			else if (os.startsWith("Linux"))
				macAddress = linuxParseMacAddress(linuxRunIfConfigCommand());
			else
				throw new IOException("unknown operating system: " + os);
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			logger.error("", e);
		}
		return macAddress;
	}

	private static final String linuxParseMacAddress(String ipConfigResponse)
			throws ParseException {
		String localHost = null;
		try {
			localHost = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
			throw new ParseException(ex.getMessage(), 0);
		}
		StringTokenizer tokenizer = new StringTokenizer(ipConfigResponse, "\n");
		String lastMacAddress = null;
		do {
			if (!tokenizer.hasMoreTokens())
				break;
			String line = tokenizer.nextToken().trim();
			boolean containsLocalHost = line.indexOf(localHost) >= 0;
			if (containsLocalHost && lastMacAddress != null)
				return lastMacAddress;
			int macAddressPosition = line.indexOf("HWaddr");
			if (macAddressPosition > 0) {
				String macAddressCandidate = line.substring(
						macAddressPosition + 6).trim();
				if (linuxIsMacAddress(macAddressCandidate))
					lastMacAddress = macAddressCandidate;
			}
		} while (true);
		ParseException ex = new ParseException("cannot read MAC address for "
				+ localHost + " from [" + ipConfigResponse + "]", 0);
		ex.printStackTrace();
		throw ex;
	}

	private static final boolean linuxIsMacAddress(String macAddressCandidate) {
		return macAddressCandidate.length() == 17;
	}

	private static final String linuxRunIfConfigCommand() throws IOException {
		Process p = Runtime.getRuntime().exec("ifconfig");
		InputStream stdoutStream = new BufferedInputStream(p.getInputStream());
		StringBuffer buffer = new StringBuffer();
		do {
			int c = stdoutStream.read();
			if (c != -1) {
				buffer.append((char) c);
			} else {
				String outputText = buffer.toString();
				stdoutStream.close();
				return outputText;
			}
		} while (true);
	}

	private static final String windowsParseMacAddress(String ipConfigResponse)
			throws ParseException {
		String localHost = null;
		try {
			localHost = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
			throw new ParseException(ex.getMessage(), 0);
		}
		String lastMacAddress = null;
		String resultLines[] = ipConfigResponse.split("\n");
		for (int i = 0; i < resultLines.length; i++) {
			if (resultLines[i].indexOf(localHost) >= 0
					&& lastMacAddress != null)
				return lastMacAddress;
			int macAddressPosition = resultLines[i].indexOf(":");
			if (macAddressPosition <= 0)
				continue;
			String macAddressCandidate = resultLines[i].substring(
					macAddressPosition + 1).trim();
			if (windowsIsMacAddress(macAddressCandidate))
				lastMacAddress = macAddressCandidate;
		}

		ParseException ex = new ParseException("cannot read MAC address from ["
				+ ipConfigResponse + "]", 0);
		ex.printStackTrace();
		throw ex;
	}

	private static final boolean windowsIsMacAddress(String macAddressCandidate) {
		return macAddressCandidate.length() == 17;
	}

	private static final String windowsRunIpConfigCommand() {
		Process process = null;
		BufferedReader bufferedReader = null;
		StringBuffer buffer = new StringBuffer();
		try {
			process = Runtime.getRuntime().exec("ipconfig /all");
			bufferedReader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			for (String line = null; (line = bufferedReader.readLine()) != null;) {
				buffer.append(line);
				buffer.append("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			bufferedReader = null;
			process = null;
		}
		return buffer.toString();
	}

	public static void main(String args[]) {
		String cpu = getCollector().getCPUID();
		String hd = getCollector().getHardDriverID();
		String mac = getCollector().getMACAddress();
//		System.out.println("CPU" + PermissionResUtil.getResource("res_79")
//				+ cpu);
//		System.out.println(PermissionResUtil.getResource("res_80") + hd);
//		System.out.println(PermissionResUtil.getResource("res_81") + mac);
		
		System.out.println("CPU" + cpu);
		System.out.println(hd);
		System.out.println(mac);
	}

	static Class _mthclass$(String x0) throws Throwable {
		try {
			return Class.forName(x0);
		} catch (ClassNotFoundException x1) {
			throw (new NoClassDefFoundError()).initCause(x1);
		}
	}

	private static Logger logger;
	private String dllName;
	private static IHardwareInfoCollector collector = null;

	static {
		logger = Logger
				.getLogger(com.common.hardware.HardwareInfoCollector.class);
	}

}
