package com.deppon.struts.action;
import java.io.*;
import com.opensymphony.xwork2.ActionSupport;

public class UploadMoreAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private java.util.List<File> uploads;
    private java.util.List<String> uploadsFileName;
    private java.util.List<String> uploadsContentType;

    public java.util.List<File> getUploads() {
		return uploads;
	}


	public void setUploads(java.util.List<File> uploads) {
		System.out.println("22222222222222222222222222");
		this.uploads = uploads;
	}


	public java.util.List<String> getUploadsFileName() {
		return uploadsFileName;
	}


	public void setUploadsFileName(java.util.List<String> uploadsFileName) {
		this.uploadsFileName = uploadsFileName;
	}


	public java.util.List<String> getUploadsContentType() {
		return uploadsContentType;
	}


	public void setUploadsContentType(java.util.List<String> uploadsContentType) {
		this.uploadsContentType = uploadsContentType;
	}


	public String execute() throws Exception
    {
        if (uploads != null)
        {
            int i = 0;
            for (; i < uploads.size(); i++)
            {
                java.io.InputStream is = new java.io.FileInputStream(uploads.get(i));
                java.io.OutputStream os = new java.io.FileOutputStream(
                        "d:\\log\\" + uploadsFileName.get(i));
                byte buffer[] = new byte[8192];
                int count = 0;
                while ((count = is.read(buffer)) > 0)
                {
                    os.write(buffer, 0, count);
                }
                os.close();
                is.close();
            }
        }
        return SUCCESS;
    }
}