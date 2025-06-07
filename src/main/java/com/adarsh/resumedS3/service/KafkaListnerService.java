package com.adarsh.resumedS3.service;

import com.adarsh.resumedS3.DTO.uploadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

@Service
public class KafkaListnerService {

    private static final Logger log = LoggerFactory.getLogger(KafkaListnerService.class);

    @Autowired
    private S3Service s3Service;

    @KafkaListener(topics = "resume-upload", groupId = "resumed-l")
    public void listen(uploadRequest message) throws IOException {
        byte[] resume = Base64.getDecoder().decode(message.getResumeFileContent());
        String resumeName = message.getResumeFileName();

        log.info("Upload message received for {}", resumeName);

        Path tempFile = Files.createTempFile("s3-", resumeName);
        Files.write(tempFile, resume);

        s3Service.uploadFile(resumeName, tempFile);
    }
}
