package com.example.krishanroy.unit_04_assessment.model;

import java.util.List;

public class OuterClass {
    private List<Messages> message;

    public OuterClass(List<Messages> message) {
        this.message = message;
    }

    public List<Messages> getMessage() {
        return message;
    }

    public void setMessage(List<Messages> message) {
        this.message = message;
    }
}
