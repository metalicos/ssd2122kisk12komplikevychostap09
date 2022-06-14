package com.komplikevych.ssd2122kisk12komplikevychostap09.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(MockitoJUnitRunner.class)
class SequenceGenerationServiceTest {

    @Test
    void ifExecuteFormulaShouldReturnGoodResult() throws Exception {
        var noVariables = new SequenceGenerationService().generateSequence("2+2", 4);
        assertEquals("4;4;4;4", noVariables);
        var withVariables = new SequenceGenerationService().generateSequence("52+x+33/((2/95)*x)", 25);
        assertTrue(Arrays.stream(withVariables.split(";")).distinct().count() > 1);
    }
}