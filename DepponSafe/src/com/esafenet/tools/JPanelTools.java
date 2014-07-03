package com.esafenet.tools;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.esafenet.action.MouseAction;

public class JPanelTools {
	
	private JTextField mainPath;
	
	private JTextField homePath;
	
	private static JPanelTools pan = null;
	
	public static JPanelTools getInstanse(){
		
		return (pan == null) ? (pan = (new JPanelTools())) : pan;
		
	}
	
	public JPanel getFilesJPanel(String title,String txtName) {
		JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());
		pan.setBorder(BorderFactory.createTitledBorder(title));
		pan.setPreferredSize(new Dimension(500, 54));
		
		JLabel dirLab = new JLabel("选择目录：", JLabel.LEFT);

		pan.add(dirLab,BorderLayout.WEST);

		JTextField dirPath = new JTextField(38);
		if("mainPath".equals(txtName)){
			this.mainPath = dirPath;
			this.mainPath.setText(ReadConfigFile.getInstance().getPathString());
//		}else{
//			this.homePath = dirPath;
//			this.homePath.setText("D:\\FTP\\已解密");
		}
		dirPath.setName(txtName);
		dirPath.setEnabled(false);
		
		dirPath.addMouseListener(new MouseAction(dirPath));

		pan.add(dirPath,BorderLayout.EAST);
		
		return pan;
	}
	
	public JTextField getMainPath(){
		return this.mainPath;
	}
	
	public JTextField getHomePath(){
		return this.homePath;
	}

}
