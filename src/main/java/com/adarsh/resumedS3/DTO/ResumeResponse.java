package com.adarsh.resumedS3.DTO;

public class ResumeResponse {
    private String content;
    private String status;

    // Constructor
    public ResumeResponse
    (String content, String status) {
        this.content = content;
        this.status = status;
    }

    // Getters and Setters
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
