package com.chesterjerrat.namechecker.models.dto;

public class CommonResponseObject {

    private String description;

    private String key;

    private String item;

    public CommonResponseObject(String description, String key, String item) {
        this.description = description;
        this.key = key;
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
