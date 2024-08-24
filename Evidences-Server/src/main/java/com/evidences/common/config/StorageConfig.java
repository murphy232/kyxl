package com.evidences.common.config;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "storage")
public class StorageConfig {
    private String imagePath;
    private String recyclePath;
}
