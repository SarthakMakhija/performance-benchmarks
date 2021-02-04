package org.learning.tech.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnoptimizedAlphanumericValidatorUnitTest {

    @Test
    void shouldBeValidGivenAnAlphanumericContent() {
        boolean isValid = UnoptimizedAlphanumericValidator.instance.isValid("contentPassingAlphanumericValidation");
        assertTrue(isValid);
    }

    @Test
    void shouldNotBeValidGivenAContentWithHyphens() {
        boolean isValid = UnoptimizedAlphanumericValidator.instance.isValid("content-Failing-Alphanumeric-Validation");
        assertFalse(isValid);
    }
}