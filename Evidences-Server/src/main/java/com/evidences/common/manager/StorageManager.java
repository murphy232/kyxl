package com.evidences.common.manager;

import com.evidences.common.config.StorageConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class StorageManager {
    private StorageConfig storageConfig;

    @Autowired
    public void setResourcesConfig(StorageConfig storageConfig) {
        this.storageConfig = storageConfig;
    }

    public boolean saveImage(byte[] imageBytes, String fileName) {
        try {
            Files.write(Paths.get(storageConfig.getImagePath()).resolve(fileName), imageBytes);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean deleteImage(String fileName) {
        try {
            Files.delete(Paths.get(storageConfig.getImagePath()).resolve(fileName));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public byte[] getImageBytes(String fileName) {
        try {
            return Files.readAllBytes(Paths.get(storageConfig.getImagePath()).resolve(fileName));
        } catch (Exception exception) {
            return null;
        }
    }
}
