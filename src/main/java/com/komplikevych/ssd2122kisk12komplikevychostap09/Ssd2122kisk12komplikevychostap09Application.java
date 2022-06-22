package com.komplikevych.ssd2122kisk12komplikevychostap09;

import com.komplikevych.ssd2122kisk12komplikevychostap09.command.MainCommand;
import com.komplikevych.ssd2122kisk12komplikevychostap09.exception.ValidationException;
import com.komplikevych.ssd2122kisk12komplikevychostap09.util.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.ini4j.Wini;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
@RequiredArgsConstructor
public class Ssd2122kisk12komplikevychostap09Application implements CommandLineRunner, ExitCodeGenerator {
    private final CommandLine.IFactory factory;
    private final MainCommand mainCommand;
    private int exitCode = 0;

    public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(Ssd2122kisk12komplikevychostap09Application.class, args)));
    }

    @Override
    public void run(String... args) throws ValidationException {
        ValidationUtils.allNull(args);
        exitCode = new CommandLine(mainCommand, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }
}
