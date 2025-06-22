package com.adarsh.resumedS3.controller;

import com.adarsh.resumedS3.DTO.Response;
import com.adarsh.resumedS3.DTO.ResumeResponse;
import com.adarsh.resumedS3.DTO.uploadRequest;
import com.adarsh.resumedS3.service.S3Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

@RestController
@RequestMapping(path = "/api/s3")
public class s3Controller {

    private static final Logger log = LoggerFactory.getLogger(s3Controller.class);

    @Autowired
    private S3Service s3Service;

    @PostMapping(path = "/upload")
    public void upload(@RequestBody uploadRequest uploadRequest) throws IOException {
        byte[] resume = Base64.getDecoder().decode(uploadRequest.getResumeFileContent());
        String resumeName = uploadRequest.getResumeFileName();

        log.info("Upload request received for {}", resumeName);

        Path tempFile = Files.createTempFile("s3-", resumeName);
        Files.write(tempFile, resume);

        s3Service.uploadFile(resumeName, tempFile);
    }

    @GetMapping(path = "/download")
    public ResumeResponse download(@RequestParam String file_name) {
        log.info("Download request received for {}", file_name);

        return new ResumeResponse(s3Service.downloadFile(file_name), "success");
    }
}
