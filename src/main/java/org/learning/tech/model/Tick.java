package org.learning.tech.model;

public class Tick {

    private final String signature;

    public Tick(String signature) {
        this.signature = signature;
    }

    public String signature() {
        return signature;
    }
}