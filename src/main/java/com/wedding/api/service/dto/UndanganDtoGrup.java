package com.wedding.api.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
public class UndanganDtoGrup {

    private String component;
    private Map<String, String> properties = new HashMap<>();

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getProperty(String key) {
        return properties.get(key);
    }

    public void setProperty(String key, String value) {
        this.properties.put(key, value);
    }

    public Map<String, String> getProperties() {
        return properties;
    }

}
