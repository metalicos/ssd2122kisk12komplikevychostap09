package com.komplikevych.ssd2122kisk12komplikevychostap09.util;


import com.komplikevych.ssd2122kisk12komplikevychostap09.exception.ValidationException;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class ValidationUtils {

    public static boolean allNull(Object... objects) throws ValidationException {
        if (Arrays.stream(objects).allMatch(Objects::isNull)) {
            throw new ValidationException("All input parameters are null");
        }
        return false;
    }

    public static boolean manualInput(String formula, Integer number) throws ValidationException {
        if (Stream.of(formula, number).anyMatch(Objects::isNull)) {
            throw new ValidationException("Manual input not full, check if you input both <sequenceFormula> and <sequenceNumber>");
        }
        return false;
    }
}
