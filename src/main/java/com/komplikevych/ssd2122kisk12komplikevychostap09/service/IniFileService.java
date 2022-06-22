package com.komplikevych.ssd2122kisk12komplikevychostap09.service;

import com.komplikevych.ssd2122kisk12komplikevychostap09.dto.SequenceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ini4j.Wini;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class IniFileService {
    private final Wini wini;

    public Optional<SequenceDto> getSequence(String filePath) {
        var path = Optional.ofNullable(filePath);
        if (path.isEmpty()) {
            return Optional.empty();
        }
        wini.setFile(new File(path.get()));
        log.info("Reading INI file");
        var formula = wini.get("sequence", "formula");
        log.info("Sequence Formula from INI file = {}", formula);
        var number = Integer.parseInt(wini.get("sequence", "number"));
        log.info("Sequence Number from INI file = {}", number);
        return Optional.of(new SequenceDto(formula, number));
    }
}
