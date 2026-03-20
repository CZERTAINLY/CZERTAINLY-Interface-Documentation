package com.otilm.openapi.codegen;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClassNameResolverTest {

    private static final List<String> INTERFACE_FQNS = List.of(
            "com.czertainly.api.interfaces.core.web.CertificateController",
            "com.czertainly.api.interfaces.connector.CertificateController",
            "com.czertainly.api.interfaces.connector.v2.CertificateController",
            "com.czertainly.api.interfaces.core.web.InfoController",
            "com.czertainly.api.interfaces.connector.InfoController",
            "com.czertainly.api.interfaces.connector.common.v2.InfoController",
            "com.czertainly.api.interfaces.connector.ComplianceController",
            "com.czertainly.api.interfaces.connector.v2.ComplianceController",
            "com.czertainly.api.interfaces.core.web.v2.ComplianceController",
            "com.czertainly.api.interfaces.core.client.ClientOperationController",
            "com.czertainly.api.interfaces.core.client.v2.ClientOperationController",
            "com.czertainly.api.interfaces.core.web.ConnectorController",
            "com.czertainly.api.interfaces.core.web.v2.ConnectorController",
            "com.czertainly.api.interfaces.connector.HealthController",
            "com.czertainly.api.interfaces.connector.common.v2.HealthController",
            "com.czertainly.api.interfaces.core.web.TokenInstanceController",
            "com.czertainly.api.interfaces.connector.cryptography.TokenInstanceController",
            "com.czertainly.api.interfaces.core.web.CryptographicOperationsController",
            "com.czertainly.api.interfaces.connector.cryptography.CryptographicOperationsController",
            "com.czertainly.api.interfaces.core.local.LocalController",
            "com.czertainly.api.interfaces.core.acme.AcmeController",
            "com.czertainly.api.interfaces.core.scep.ScepController",
            "com.czertainly.api.interfaces.connector.entity.EntityController",
            "com.czertainly.api.interfaces.connector.secrets.VaultController"
    );

    @ParameterizedTest(name = "{0} -> {1}")
    @MethodSource("interfaceNameCases")
    void generatesExpectedImplementationName(String interfaceFqn, String expectedName) {
        String implClassName = ClassNameResolver.generateImplementationClassName(interfaceFqn);

        assertEquals(expectedName, implClassName);
        assertTrue(ClassNameResolver.isValidImplementationClassName(implClassName));
    }

    @Test
    void generatedNamesAreUnique() {
        Set<String> names = INTERFACE_FQNS.stream()
                .map(ClassNameResolver::generateImplementationClassName)
                .collect(Collectors.toSet());

        assertEquals(INTERFACE_FQNS.size(), names.size());
    }

    private static Stream<Arguments> interfaceNameCases() {
        return Stream.of(
                Arguments.of("com.czertainly.api.interfaces.core.web.CertificateController", "CoreWebCertificateControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.connector.CertificateController", "ConnectorCertificateControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.connector.v2.CertificateController", "ConnectorV2CertificateControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.core.web.InfoController", "CoreWebInfoControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.connector.InfoController", "ConnectorInfoControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.connector.common.v2.InfoController", "ConnectorCommonV2InfoControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.connector.ComplianceController", "ConnectorComplianceControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.connector.v2.ComplianceController", "ConnectorV2ComplianceControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.core.web.v2.ComplianceController", "CoreWebV2ComplianceControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.core.client.ClientOperationController", "CoreClientClientOperationControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.core.client.v2.ClientOperationController", "CoreClientV2ClientOperationControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.core.web.ConnectorController", "CoreWebConnectorControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.core.web.v2.ConnectorController", "CoreWebV2ConnectorControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.connector.HealthController", "ConnectorHealthControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.connector.common.v2.HealthController", "ConnectorCommonV2HealthControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.core.web.TokenInstanceController", "CoreWebTokenInstanceControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.connector.cryptography.TokenInstanceController", "ConnectorCryptographyTokenInstanceControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.core.web.CryptographicOperationsController", "CoreWebCryptographicOperationsControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.connector.cryptography.CryptographicOperationsController", "ConnectorCryptographyCryptographicOperationsControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.core.local.LocalController", "CoreLocalLocalControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.core.acme.AcmeController", "CoreAcmeAcmeControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.core.scep.ScepController", "CoreScepScepControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.connector.entity.EntityController", "ConnectorEntityEntityControllerDummyImpl"),
                Arguments.of("com.czertainly.api.interfaces.connector.secrets.VaultController", "ConnectorSecretsVaultControllerDummyImpl")
        );
    }
}