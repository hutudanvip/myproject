package com.esafenet.tools;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JTextAreaTools {
	
	private static JTextAreaTools area = null;
	
	private javax.swing.JTextArea txtArea = null;
	
	public static JTextAreaTools getInstance(){
		return (area == null) ? (area = new JTextAreaTools()) : area;
	}
	
	
	public JPanel getJTextAearJPanel(){
		
		JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());
		pan.setBorder(BorderFactory.createTitledBorder("详细列表"));
		
		pan.setPreferredSize(new Dimension(588, 350));
		
		txtArea = new JTextArea();
		txtArea.setLineWrap(false);
		
		JScrollPane scroll = new JScrollPane(txtArea);
		//设置水平滚动条自动出现
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		//设置垂直滚动条自动出现
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	
		pan.add(scroll);
		
		return pan; 
	}
	
	public void setJTextAreaText(String str){
		this.txtArea.setText(str);
	}
	
	public void compareToBegin(String str){
		this.txtArea.setText(str + "\r\n" + this.txtArea.getText());
	}
	
	public void compareToEnd(String str){
		if("".equals(this.txtArea.getText()))
			this.txtArea.setText(str);
		else
			this.txtArea.setText(this.txtArea.getText() + "\r\n" + str);
	}
	
	public javax.swing.JTextArea getTextArea(){
		return this.txtArea;
	}

}
