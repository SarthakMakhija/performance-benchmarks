package org.learning.tech.validator;

public class UnoptimizedAlphanumericValidator implements Validator {

    public static final UnoptimizedAlphanumericValidator instance = new UnoptimizedAlphanumericValidator();

    private UnoptimizedAlphanumericValidator() {
    }

    @Override
    public boolean isValid(String content) {
        return content.matches("[A-Za-z0-9\s]+");
    }
}