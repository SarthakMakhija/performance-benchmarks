package org.learning.tech.validator;

import java.util.regex.Pattern;

public class OptimizedAlphanumericValidator implements Validator {

    public static final OptimizedAlphanumericValidator instance = new OptimizedAlphanumericValidator();
    private static final Pattern alphanumericPattern = Pattern.compile("[A-Za-z0-9\s]+");

    private OptimizedAlphanumericValidator() {
    }

    @Override
    public boolean isValid(String content) {
        return alphanumericPattern.matcher(content).matches();
    }
}