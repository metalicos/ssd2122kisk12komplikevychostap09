package com.komplikevych.ssd2122kisk12komplikevychostap09.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SequenceGenerationService {
    public static final String VARIABLE_X = "x";
    public static final int MAX_RANDOM = 25;
    public static final int MIN_RANDOM = -5;
    public static final String OUTPUT_FILENAME = "sequence.csv";

    private Object executeFormula(String formula) throws ScriptException {
        var jsEngine = new ScriptEngineManager().getEngineByName("JavaScript");
        var result = jsEngine.eval(formula);
        log.info("Successfully calculated formula. Result={}", result);
        return result;
    }

    public String generateSequence(String sequenceFormula, Integer sequenceNum) throws NoSuchAlgorithmException, ScriptException {
        List<String> sequenceRow = new ArrayList<>();
        for (var i = 0; i < sequenceNum; i++) {
            var newVariable = String.format("(%s)", SecureRandom.getInstanceStrong().nextInt(MAX_RANDOM) + MIN_RANDOM);
            var formulaWithInjectedValue = sequenceFormula.replaceAll(VARIABLE_X, newVariable);
            String seqElement = String.valueOf(executeFormula(formulaWithInjectedValue));
            sequenceRow.add(seqElement);
        }
        log.info("Successfully generated");
        return String.join(";", sequenceRow);
    }

    public void saveSequence(String sequence) throws IOException {
        if (!Files.exists(Path.of(OUTPUT_FILENAME))) {
            Files.createFile(Path.of(OUTPUT_FILENAME));
        }
        Files.writeString(Path.of(OUTPUT_FILENAME), sequence);
        log.info("Successfully saved");
    }
}
