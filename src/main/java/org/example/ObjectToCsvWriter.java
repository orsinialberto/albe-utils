package org.example;

import com.github.javafaker.Faker;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.example.model.CsvBean;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNullElse;

public class ObjectToCsvWriter implements Processor {

    private final int lines;
    private final Path path;

    public ObjectToCsvWriter(int lines, String path) {
        this.lines = lines;
        this.path = Path.of(requireNonNullElse(path, "src/main/resources/result/job3-100k.csv"));
    }

    public void run() throws Exception {
        writeCsvFromBean(path);
    }

    private void writeCsvFromBean(final Path path) throws Exception {

        Faker faker = new Faker();

        final List<CsvBean> sampleData = new ArrayList<>();

        for (int i = 0; i < lines; i++) {

            final String firstName = faker.name().firstName().toLowerCase();
            final String lastName = faker.name().lastName().toLowerCase();
            final String email = firstName + "." + lastName + "@contactlabo.com";
            int id = i+1;

            final CsvBean csvBean = new CsvBean(id, email, firstName, lastName);

            sampleData.add(csvBean);
        }

        try (Writer writer  = new FileWriter(path.toString())) {

            final StatefulBeanToCsv<CsvBean> sbc = new StatefulBeanToCsvBuilder<CsvBean>(writer)
                    .withSeparator(',')
                    .withApplyQuotesToAll(false)
                    .withMappingStrategy(new AnnotationStrategy(CsvBean.class))
                    .build();

            sbc.write(sampleData);
        }
    }
}
