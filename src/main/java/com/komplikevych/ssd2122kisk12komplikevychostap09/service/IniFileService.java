package com.komplikevych.ssd2122kisk12komplikevychostap09.service;

import com.komplikevych.ssd2122kisk12komplikevychostap09.dto.SequenceDto;
import lombok.extern.slf4j.Slf4j;
import org.ini4j.Wini;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
public class IniFileService {

    public Optional<SequenceDto> getSequence(String filePath) throws IOException {
        var path = Optional.ofNullable(filePath);
        if (path.isEmpty()){
            return Optional.empty();
        }
        var ini = new Wini(new File(path.get()));
        log.info("Reading INI file");
        var formula = ini.get("sequence", "formula");
        log.info("Sequence Formula from INI file = {}", formula);
        var number = Integer.parseInt(ini.get("sequence", "number"));
        log.info("Sequence Number from INI file = {}", number);
        return Optional.of(new SequenceDto(formula, number));
    }
}
