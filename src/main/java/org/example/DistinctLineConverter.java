package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static java.lang.System.out;

public class DistinctLineConverter implements Processor{

    private static final String FILE = "src/main/resources/graylog-enqueue-log-sorted.csv";

    public void run() throws IOException {
        final Set<String> distinctLine = readDistinctLine();
        distinctLine.forEach(out::println);
    }

    private Set<String> readDistinctLine() throws IOException {

        final Set<String> distinct = new HashSet<>();

        try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while (Objects.nonNull(line = bufferedReader.readLine())) {
                distinct.add(line);
            }
        }
        return distinct;
    }
}
