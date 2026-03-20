package com.otilm.openapi.config.util;

/**
 * Utility class for generating unique, collision-free class names for dummy implementations.
 * Uses package-based prefixes to ensure interfaces with the same simple name from different
 * packages generate unique implementation class names.
 * <p>
 * For example:
 * - com.czertainly.api.interfaces.core.web.CertificateController -> CoreWebCertificateControllerDummyImpl
 * - com.czertainly.api.interfaces.connector.CertificateController -> ConnectorCertificateControllerDummyImpl
 * - com.czertainly.api.interfaces.connector.v2.CertificateController -> ConnectorV2CertificateControllerDummyImpl
 * <p>
 * This class must be kept in sync with the ClassNameResolver in the codegen module.
 */
public class ClassNameResolver {

    private static final String BASE_PACKAGE = "com.czertainly.api.interfaces.";

    /**
     * Generates a unique implementation class name from a fully qualified interface name.
     *
     * @param interfaceFqn fully qualified interface name
     * @return unique implementation class name
     */
    public static String generateImplementationClassName(String interfaceFqn) {
        int lastDotIndex = interfaceFqn.lastIndexOf('.');
        String packageName = interfaceFqn.substring(0, lastDotIndex);
        String simpleName = interfaceFqn.substring(lastDotIndex + 1);
        
        String packagePrefix = extractPackagePrefix(packageName);
        return packagePrefix + simpleName + "DummyImpl";
    }

    /**
     * Extracts a package prefix from the package name by removing the base package
     * and capitalizing each segment.
     * <p>
     * Examples:
     * - "com.czertainly.api.interfaces.core.web" -> "CoreWeb"
     * - "com.czertainly.api.interfaces.connector.v2" -> "ConnectorV2"
     * - "com.czertainly.api.interfaces.connector.common.v2" -> "ConnectorCommonV2"
     *
     * @param packageName the full package name
     * @return capitalized package prefix
     */
    private static String extractPackagePrefix(String packageName) {
        // Remove the common base package
        String relativePath = packageName.startsWith(BASE_PACKAGE) 
                ? packageName.substring(BASE_PACKAGE.length())
                : packageName;

        // If no relative path, use the last segment of the package
        if (relativePath.isEmpty()) {
            int lastDotIndex = packageName.lastIndexOf('.');
            relativePath = lastDotIndex >= 0 
                    ? packageName.substring(lastDotIndex + 1)
                    : packageName;
        }

        // Split into segments and capitalize each
        String[] segments = relativePath.split("\\.");
        StringBuilder prefix = new StringBuilder();
        
        for (String segment : segments) {
            if (!segment.isEmpty()) {
                // Capitalize first letter, keep rest as-is (to preserve v2, v3, etc.)
                prefix.append(Character.toUpperCase(segment.charAt(0)))
                      .append(segment.substring(1));
            }
        }

        return prefix.toString();
    }

    /**
     * Validates that a class name follows the expected naming convention.
     *
     * @param className the class name to validate
     * @return true if the class name ends with "DummyImpl"
     */
    public static boolean isValidImplementationClassName(String className) {
        return className != null && className.endsWith("DummyImpl");
    }
}
