package com.esafenet.tools;

import java.awt.FileDialog;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FileDialogTools {
	
	private Object obj = null;
	
	private String title = "文件选择器";
	
	public FileDialogTools(){
		super();
	}
	
	public FileDialogTools(Object obj,String title){
		this.obj = obj;
		
		this.title = ((title == null || "".equals(title)) ? this.title : title);
	}
	
	public void showDirDialog() {
		
		FileDialog fd = new FileDialog(new JFrame(), title, FileDialog.LOAD);
		
		FilenameFilter ff = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				if (name.endsWith("jpg")) {
					return true;
				}
				return false;
			}
		};
		fd.setFilenameFilter(ff);
		fd.setVisible(true);
		if(this.obj instanceof javax.swing.JTextField && fd.getDirectory() != null && fd.getFile() != null){
			javax.swing.JTextField txt = (javax.swing.JTextField)this.obj;
			txt.setText(fd.getDirectory() + fd.getFile());
		}
	}
	
	public void showFileDialog() {
		FileDialog fd = new FileDialog(new JFrame(), title, FileDialog.LOAD);
		FilenameFilter ff = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				if (name.endsWith("jpg")) {
					return true;
				}
				return false;
			}
		};
		fd.setFilenameFilter(ff);
		fd.setVisible(true);
		if(this.obj instanceof javax.swing.JTextField && fd.getDirectory() != null && fd.getFile() != null){
			javax.swing.JTextField txt = (javax.swing.JTextField)this.obj;
			txt.setText(fd.getDirectory() + fd.getFile());
		}

	}
	
	public void getFileChooser(JTextField txt,String Dir,String pathName){
		
		javax.swing.JFileChooser files = new JFileChooser(Dir);
		files.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result;
		if("mainPath".equals(pathName)){
			result = files.showOpenDialog(null);
		}else{
			result = files.showSaveDialog(null);
		}
		if(result == JFileChooser.APPROVE_OPTION){
			
			txt.setText(files.getSelectedFile().getPath());
			
			ReadConfigFile.getInstance().setDefaultPath(files.getSelectedFile().getPath());
		}
		
	}

}
