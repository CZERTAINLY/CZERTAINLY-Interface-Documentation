package com.czertainly.openapi.codegen;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Generates dummy controller implementations from the groups.yaml configuration.
 * This is a standalone tool that runs during the Maven build to create @RestController
 * classes that implement the interfaces defined in groups.yaml.
 * <p>
 * Uses reflection to inspect interfaces and generate proper method implementations.
 * Validates that each interface extends one of the three base security controllers.
 * Annotates generated classes with @SecuritySchemeCategory metadata.
 * <p>
 */
public class DummyControllerGenerator {

    private static final String PACKAGE_NAME = "com.czertainly.openapi.generated";

    private final ConfigurationLoader configLoader;
    private SecuritySchemeExtractor securitySchemeExtractor;

    public DummyControllerGenerator() {
        this.configLoader = new ConfigurationLoader();
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: DummyControllerGenerator <groups.yaml path> <output directory>");
            System.exit(1);
        }

        String groupsYamlPath = args[0];
        String outputDir = args[1];

        printHeader(groupsYamlPath, outputDir);

        DummyControllerGenerator generator = new DummyControllerGenerator();
        generator.generate(groupsYamlPath, outputDir);
    }

    /**
     * Main generation method that orchestrates the entire process.
     */
    public void generate(String groupsYamlPath, String outputDir) throws IOException {
        // Load security configuration
        ConfigurationLoader.SecurityConfiguration securityConfig = configLoader.loadSecurityConfiguration(groupsYamlPath);
        this.securitySchemeExtractor = new SecuritySchemeExtractor(securityConfig);

        // Load interface configuration
        Set<String> allInterfaces = configLoader.loadInterfaces(groupsYamlPath);
        int groupCount = configLoader.getGroupCount(groupsYamlPath);

        System.out.println("Found " + groupCount + " groups with " + allInterfaces.size() + " unique interfaces");
        System.out.println();

        // Generate implementations
        GenerationResult result = generateAllControllers(allInterfaces, outputDir);

        printSummary(result);

        if (result.failCount > 0) {
            System.exit(1);
        }
    }

    /**
     * Generates dummy controllers for all interfaces.
     */
    private GenerationResult generateAllControllers(Set<String> interfaces, String outputDir) {
        FileWriter fileWriter = new FileWriter(outputDir, PACKAGE_NAME);
        int successCount = 0;
        int failCount = 0;

        for (String interfaceFqn : interfaces) {
            try {
                generateDummyController(interfaceFqn, fileWriter);
                successCount++;
            } catch (Exception e) {
                System.err.println("❌ Failed to generate dummy for " + interfaceFqn + ": " + e.getMessage());
                failCount++;
            }
        }

        return new GenerationResult(successCount, failCount);
    }

    /**
     * Generates a single dummy controller implementation for the given interface.
     * Validates that the interface extends one of the three base security controllers.
     */
    private void generateDummyController(String interfaceFqn, FileWriter fileWriter) throws Exception {
        Class<?> interfaceClass = loadInterfaceClass(interfaceFqn);

        String baseSecurityClass = securitySchemeExtractor.determineBaseSecurityClass(interfaceClass);
        List<String> securitySchemes = securitySchemeExtractor.getSecuritySchemesForBaseClass(baseSecurityClass);

        // Generate implementation code with unique naming
        String implClassName = ClassNameResolver.generateImplementationClassName(interfaceClass);
        TypeResolver typeResolver = new TypeResolver(interfaceClass);
        CodeGenerator codeGenerator = new CodeGenerator(typeResolver, PACKAGE_NAME, implClassName,
                baseSecurityClass, securitySchemes);
        String sourceCode = codeGenerator.generateImplementation(interfaceClass);

        fileWriter.writeImplementation(implClassName, sourceCode);

        int methodCount = countNonObjectMethods(interfaceClass);
        String baseClassName = baseSecurityClass.substring(baseSecurityClass.lastIndexOf('.') + 1);
        System.out.println("✓ Generated " + implClassName + " (" + methodCount + " methods, " + baseClassName + ")");
    }

    /**
     * Loads an interface class by its fully qualified name using reflection.
     */
    private Class<?> loadInterfaceClass(String interfaceFqn) throws ClassNotFoundException {
        try {
            return Class.forName(interfaceFqn);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Interface not found: " + interfaceFqn +
                    ". Make sure the interfaces JAR is on the classpath.", e);
        }
    }

    /**
     * Counts the number of methods in the interface (excluding Object methods).
     */
    private int countNonObjectMethods(Class<?> interfaceClass) {
        int count = 0;
        for (var method : interfaceClass.getMethods()) {
            if (!method.getDeclaringClass().equals(Object.class)) {
                count++;
            }
        }
        return count;
    }

    private static void printHeader(String configPath, String outputDir) {
        System.out.println("=".repeat(70));
        System.out.println("Dummy Controller Generator");
        System.out.println("=".repeat(70));
        System.out.println("Configuration: " + configPath);
        System.out.println("Output directory: " + outputDir);
        System.out.println();
    }

    private static void printSummary(GenerationResult result) {
        System.out.println();
        System.out.println("=".repeat(70));
        System.out.println("✅ Successfully generated " + result.successCount + " dummy controller classes");
        if (result.failCount > 0) {
            System.err.println("❌ Failed to generate " + result.failCount + " classes");
        }
        System.out.println("=".repeat(70));
    }

    private record GenerationResult(int successCount, int failCount) {
    }
}
