package com.komplikevych.ssd2122kisk12komplikevychostap09;

import com.komplikevych.ssd2122kisk12komplikevychostap09.command.MainCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import picocli.CommandLine;

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
    public void run(String... args) throws Exception {
       exitCode = new CommandLine(mainCommand, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }
}
