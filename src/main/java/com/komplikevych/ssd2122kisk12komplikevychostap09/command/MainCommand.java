package com.komplikevych.ssd2122kisk12komplikevychostap09.command;

import com.komplikevych.ssd2122kisk12komplikevychostap09.dto.SequenceDto;
import com.komplikevych.ssd2122kisk12komplikevychostap09.service.IniFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@Slf4j
@Component
@CommandLine.Command(
        name = "mainCommand",
        mixinStandardHelpOptions = true,
        helpCommand = true, version = "0.0.1")
@RequiredArgsConstructor
public class MainCommand implements Callable<Integer> {

    private final IniFileService iniFileService;

    @CommandLine.Option(names = {"-sf", "--seqfile"}, description = "Path to sequence file")
    private String sequenceFilePath = null;

    @CommandLine.Option(names = {"-s", "--sequence"}, description = "Manual sequence formula input")
    private String sequenceFormula = null;

    @CommandLine.Option(names = {"-n", "--number"}, description = "Sequence number")
    private Integer sequenceNumber = null;

    @Override
    public Integer call() throws Exception {
        var sequenceDto = iniFileService.getSequence(sequenceFilePath)
                .orElse(new SequenceDto(sequenceFormula, sequenceNumber));
        log.info("Executing program\n\n");
        log.info("Formula={}", sequenceDto.getFormula());
        log.info("Sequence number={}", sequenceDto.getNumber());
        return 0;
    }
}
