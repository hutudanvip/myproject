package com.esafenet.ui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import com.esafenet.action.RunFileAction;
import com.esafenet.tools.JPanelTools;
import com.esafenet.tools.JTextAreaTools;
import com.esafenet.tools.ReadConfigFile;

public class WinMainUi extends javax.swing.JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WinMainUi(String title){
		
		this.setTitle(title);

		this.setSize(600, 450);

		this.setLocationRelativeTo(null);
		
		this.setResizable(false);

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout(FlowLayout.LEADING,2,2));

		contentPane.add(JPanelTools.getInstanse().getFilesJPanel("源目录","mainPath"));
		

		JButton runBtn = new javax.swing.JButton(" 运行 ");
		runBtn.setName("runDir");
		runBtn.addActionListener(new RunFileAction(runBtn));
		
		contentPane.add(runBtn);
		
		contentPane.add(JTextAreaTools.getInstance().getJTextAearJPanel());

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				
				ReadConfigFile.getInstance().saveDefaultPath(JPanelTools.getInstanse().getMainPath().getText());
				
				System.exit(0);
			}
		});
	}


	public static void main(String[] args) {
		new WinMainUi("办公小工具").setVisible(true);
	}
	
}
