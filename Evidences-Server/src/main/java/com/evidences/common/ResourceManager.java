package com.evidences.common;

import com.evidences.config.ResourceConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class ResourceManager {
    private ResourceConfig resourceConfig;

    @Autowired
    public void setResourcesConfig(ResourceConfig resourceConfig) {
        this.resourceConfig = resourceConfig;
    }

    public boolean saveImage(byte[] imageBytes, String fileName) {
        try {
            Files.write(Paths.get(resourceConfig.getImagePath()).resolve(fileName), imageBytes);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean deleteImage(String fileName) {
        try {
            Files.delete(Paths.get(resourceConfig.getImagePath()).resolve(fileName));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public byte[] getImageBytes(String fileName) {
        try {
            return Files.readAllBytes(Paths.get(resourceConfig.getImagePath()).resolve(fileName));
        } catch (Exception exception) {
            return null;
        }
    }
}
