package com.example.eduardorodriguez.calculadoracambiomoneda.entity;

/**
 * Created by eduardorodriguez on 5/20/17.
 */

public class Currency {
    private String text;
    private String value;

    public  Currency(String aText, String aValue) {
        text = aText;
        value = aValue;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
