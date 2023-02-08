package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonToYamlWriter implements Processor {

    private static final Path FILE_PATH = Path.of("src/main/resources/context.json");
    private static final String FILE_DEST = "src/main/resources/result/%s.yml";

    public void run() throws IOException {
        System.out.println(convertJsonToYaml());
    }

    private String convertJsonToYaml() throws IOException {

        final String content = Files.readString(FILE_PATH);
        final JsonNode jsonNodeTree = new ObjectMapper().readTree(content);
        final ArrayNode elements = (ArrayNode) jsonNodeTree.get("elements");

        elements
            .forEach(jsonNode -> {
                try {
                    final String filename = String.format(FILE_DEST, jsonNode.get("id").textValue());
                    final String yaml = new YAMLMapper().writeValueAsString(jsonNode);
                    Files.writeString(Path.of(filename), yaml);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        return new YAMLMapper().writeValueAsString(jsonNodeTree);
    }
}
