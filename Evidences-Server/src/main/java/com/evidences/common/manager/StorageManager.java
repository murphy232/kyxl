package com.evidences.common.manager;

import com.evidences.common.config.StorageConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;
import java.util.UUID;

@Component
public class StorageManager {
    private StorageConfig storageConfig;

    @Autowired
    public void setStorageConfig(StorageConfig storageConfig) {
        this.storageConfig = storageConfig;
    }

    public String getRandomName() {
        return UUID.randomUUID().toString();
    }

    public boolean saveContent(byte[] imageBytes, String filename) {
        try {
            Files.write(Paths.get(storageConfig.getContentPath()).resolve(filename), imageBytes);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean deleteContent(String filename) {
        try {
            Files.delete(Paths.get(storageConfig.getContentPath()).resolve(filename));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public void deleteContents(List<String> filenames) {
        for (String filename : filenames) {
            deleteContent(filename);
        }
    }

    public byte[] getContentBytes(String filename) {
        try {
            return Files.readAllBytes(Paths.get(storageConfig.getContentPath()).resolve(filename));
        } catch (Exception exception) {
            return null;
        }
    }
}
