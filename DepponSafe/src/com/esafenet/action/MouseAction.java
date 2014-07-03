package com.esafenet.action;

import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import com.esafenet.tools.FileDialogTools;
import com.esafenet.tools.ReadConfigFile;

public class MouseAction implements javax.swing.event.MouseInputListener{
	
	private JTextField txt = null;
	
	public MouseAction(JTextField txt){
		this.txt = txt;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(this.txt != null && "mainPath".equals(this.txt.getName())){
			new FileDialogTools().getFileChooser(txt, ReadConfigFile.getInstance().getDefaultPath(), "mainPath");
		}else if(this.txt != null && "homePath".equals(this.txt.getName())){
			new FileDialogTools().getFileChooser(txt, ReadConfigFile.getInstance().getDefaultPath(), "homePath");
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
