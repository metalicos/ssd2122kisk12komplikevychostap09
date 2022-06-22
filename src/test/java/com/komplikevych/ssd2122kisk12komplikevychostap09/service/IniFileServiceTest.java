package com.komplikevych.ssd2122kisk12komplikevychostap09.service;


import org.ini4j.Wini;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
class IniFileServiceTest {
    public static final String FORMULA = "formula";
    public static final String NUMBER = "number";
    private IniFileService iniFileService;
    private Wini wini;

    @BeforeEach
    void setUp() throws IOException {
        wini = mock(Wini.class);
        iniFileService = new IniFileService(wini);
    }

    @Test
    void whenFilePathTransmitted_shouldReturnOptionalWithDto() throws IOException {
        when(wini.get(anyString(),eq(FORMULA))).thenReturn("(4*x*x*x)+((3/4)*x*x)+(2*x)-11");
        when(wini.get(anyString(),eq(NUMBER))).thenReturn("100");
        var sequence = iniFileService.getSequence("test-sequencefile.ini");
        assertFalse(sequence.isEmpty());
        assertEquals("(4*x*x*x)+((3/4)*x*x)+(2*x)-11", sequence.get().getFormula());
        assertEquals(100, sequence.get().getNumber());
    }

    @Test
    void whenFilePathNotTransmitted_shouldReturnEmptyOptional() throws IOException {
        //Call mocked service; fillePath parameter not setted (null)
        var sequence = iniFileService.getSequence(null);
        //sequence dto should be empty
        assertTrue(sequence.isEmpty());
    }
}