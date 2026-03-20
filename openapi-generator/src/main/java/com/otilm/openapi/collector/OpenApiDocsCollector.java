package com.otilm.openapi.collector;

import com.otilm.openapi.config.loader.GroupsConfigLoader;
import com.otilm.openapi.config.model.GroupConfiguration;
import com.otilm.openapi.config.model.GroupsConfig;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Downloads OpenAPI YAML specs from a running Spring Boot application for all groups
 * defined in groups.yaml and saves them to the output directory.
 * <p>
 * Arguments:
 * args[0] - Path to groups.yaml
 * args[1] - Server port
 * args[2] - Output directory
 */
public class OpenApiDocsCollector {

    public static void main(String[] args) throws Exception {
        if (args.length < 3) {
            System.err.println("Usage: OpenApiDocsCollector <groups.yaml> <server-port> <output-dir>");
            System.exit(1);
        }

        String groupsYamlPath = args[0];
        int serverPort = Integer.parseInt(args[1]);
        Path outputDir = Paths.get(args[2]);

        System.out.println("Generating OpenAPI documentation files...");
        System.out.println("Groups config: " + groupsYamlPath);
        System.out.println("Server port:   " + serverPort);
        System.out.println("Output directory: " + outputDir);
        System.out.println();

        GroupsConfig config = new GroupsConfigLoader().loadFromFilesystem(groupsYamlPath);
        if (config == null) {
            System.err.println("Error: groups.yaml not found at " + groupsYamlPath);
            System.exit(1);
        }

        Files.createDirectories(outputDir);

        List<String> failed = new ArrayList<>();
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            for (GroupConfiguration group : config.getGroups()) {
                String url = "http://localhost:" + serverPort + "/v3/api-docs.yaml/" + group.getGroupName();
                Path outputFile = outputDir.resolve(group.getId() + ".yaml");

                System.out.println("Generating " + group.getId() + " from " + url + " ...");

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .GET()
                        .build();

                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == 200) {
                    Files.writeString(outputFile, response.body());
                    System.out.println("  ✓ Generated: " + outputFile);
                } else {
                    System.err.println("  ✗ Failed to generate " + group.getId() + " (HTTP " + response.statusCode() + ")");
                    System.err.println("    URL: " + url);
                    failed.add(group.getId());
                }
            }
        }

        System.out.println();
        if (!failed.isEmpty()) {
            System.err.println("Failed to generate " + failed.size() + " OpenAPI documentation file(s): " + failed);
            System.exit(1);
        }

        System.out.println("Successfully generated " + config.getGroups().size() + " OpenAPI documentation files");
        System.out.println("OpenAPI documentation generation complete!");
    }
}
