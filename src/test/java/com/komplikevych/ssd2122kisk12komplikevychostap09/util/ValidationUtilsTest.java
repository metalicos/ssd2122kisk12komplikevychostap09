package com.komplikevych.ssd2122kisk12komplikevychostap09.util;

import com.komplikevych.ssd2122kisk12komplikevychostap09.exception.ValidationException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;



import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)
class ValidationUtilsTest {

    @Test
    void ifAllNull_throwValidationException() {
        assertThrows(ValidationException.class, () -> {
            ValidationUtils.allNull(null, null, null);
        });
    }

    @Test
    void ifAnyNonNull_NothingIsThrown() {
        assertDoesNotThrow(() -> {
            ValidationUtils.allNull("path", null, null);
        });
    }

    @Test
    void ifAnyManualParamsNotSet_ThrowValidationException() {
        assertThrows(ValidationException.class, () -> {
            ValidationUtils.manualInput("formula", null);
        });
    }

    @Test
    void ifAllManualParamsSet_NothingIsThrow() {
        assertDoesNotThrow(() -> {
            ValidationUtils.manualInput("formula", 100);
        });
    }
}