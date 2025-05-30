package com.adarsh.resumedS3.DTO;

public class uploadRequest {
    private String resumeFileName;
    private String resumeFileContent;

    public String getResumeFileName() {
        return resumeFileName;
    }

    public void setResumeFileName(String resumeFileName) {
        this.resumeFileName = resumeFileName;
    }

    public String getResumeFileContent() {
        return resumeFileContent;
    }

    public void setResumeFileContent(String resumeFileContent) {
        this.resumeFileContent = resumeFileContent;
    }
}
