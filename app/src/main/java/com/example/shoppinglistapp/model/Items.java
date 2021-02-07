package com.example.shoppinglistapp.model;

public class Items {
    private String id;
    private String text;
    private Boolean checkbox;

    public Items() {
    }

    public Items(String id, String text, Boolean checkbox) {
        this.id = id;
        this.text = text;
        this.checkbox = checkbox;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(Boolean checkbox) {
        this.checkbox = checkbox;
    }
}
