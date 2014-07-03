package com.esafenet.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import com.esafenet.dll.DepponFileSafe;
import com.esafenet.tools.JPanelTools;
import com.esafenet.tools.JTextAreaTools;

public class RunFileAction  implements ActionListener {
	
	private JButton btn = null;
			
	public RunFileAction(JButton btn) {
		this.btn = btn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.btn != null && "runDir".equals(this.btn.getName())){
			runDir();
		}
	}

	private void runDir(){
		long startTime = System.currentTimeMillis();
		
		JTextAreaTools.getInstance().setJTextAreaText("................................开始处理.................................");
		
		this.btn.setEnabled(false);
		
		DepponFileSafe ext = new DepponFileSafe(JPanelTools.getInstanse().getMainPath().getText());
		try {
			ext.decryptionFileDir();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JTextAreaTools.getInstance().compareToEnd(e.getLocalizedMessage());
		}
		this.btn.setEnabled(true);
		
		JTextAreaTools.getInstance().compareToEnd("\r\n共有   " + ext.getDirSize() + "  个目录、" +ext.getAllFileCount()+"  个文件，已处理："+ext.getFileSize()+"  件文件，用时：" + (System.currentTimeMillis() - startTime) + "  毫秒！");
	}
	
}
