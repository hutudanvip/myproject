package com.deppon.struts.action;
import java.io.*;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport 
{
	private static final long serialVersionUID = 1L;
	private File upload;
    private String uploadFileName;
    private String uploadContentType;
    
    public String getUploadFileName()
    {
        return uploadFileName;
    }

    public void setUploadFileName(String fileName)
    {
    	System.out.println("fileName:" + fileName);
        this.uploadFileName = fileName;
    }

    public File getUpload()
    {
        return upload;
    }

    public void setUpload(File upload)
    {
        this.upload = upload;
    }
    public void setUploadContentType(String contentType)
    {
    	System.out.println("contentType:" + contentType);
        this.uploadContentType=contentType;
    }
    
    public String getUploadContentType()
    {
        return this.uploadContentType;
    }
    public String execute() throws Exception
    {   
        java.io.InputStream is = new java.io.FileInputStream(upload);
        java.io.OutputStream os = new java.io.FileOutputStream("d:\\log\\" + uploadFileName);
        byte buffer[] = new byte[8192];
        int count = 0;
        while((count = is.read(buffer)) > 0)
        {
            os.write(buffer, 0, count);
        }
        os.close();
        is.close();
        return SUCCESS;
    }
}