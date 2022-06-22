package com.komplikevych.ssd2122kisk12komplikevychostap09.command;

import com.komplikevych.ssd2122kisk12komplikevychostap09.dto.SequenceDto;
import com.komplikevych.ssd2122kisk12komplikevychostap09.service.IniFileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class MainCommandTest {

    public static final String TEST_FILE = "somePath";
    public static final String FORMULA = "2+(-4)*5";
    public static final int NUMBER = 16;
    private MainCommand mainCommand;
    private IniFileService iniFileService;

    @BeforeEach
    void setUp() {
        iniFileService = mock(IniFileService.class);
        mainCommand = new MainCommand(iniFileService);
    }

    @Test
    void ifSequenceDataTransmittedResponseCodeZero() throws Exception {
        ReflectionTestUtils.setField(mainCommand, "sequenceFilePath", TEST_FILE);
        when(iniFileService.getSequence(eq(TEST_FILE)))
                .thenReturn(Optional.of(new SequenceDto(FORMULA, NUMBER)));
        Integer responseCode = mainCommand.call();
        assertEquals(0, responseCode);
    }


    @Test
    void ifSequenceDataNotTransmittedResponseCodeOne() throws Exception {
        when(iniFileService.getSequence(eq(TEST_FILE)))
                .thenReturn(Optional.of(new SequenceDto(FORMULA, NUMBER)));
        mainCommand.call();
        Integer responseCode = mainCommand.call();
        assertEquals(1, responseCode);
    }
}