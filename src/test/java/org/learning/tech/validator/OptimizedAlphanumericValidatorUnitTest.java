package org.learning.tech.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OptimizedAlphanumericValidatorUnitTest {

    @Test
    void shouldBeValidGivenAnAlphanumericContent() {
        boolean isValid = OptimizedAlphanumericValidator.instance.isValid("contentPassingAlphanumericValidation");
        assertTrue(isValid);
    }

    @Test
    void shouldNotBeValidGivenAContentWithHyphens() {
        boolean isValid = OptimizedAlphanumericValidator.instance.isValid("content-Failing-Alphanumeric-Validation");
        assertFalse(isValid);
    }
}