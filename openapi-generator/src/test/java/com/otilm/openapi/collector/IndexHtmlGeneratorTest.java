package com.otilm.openapi.collector;

import com.otilm.openapi.config.model.GroupConfiguration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IndexHtmlGeneratorTest {

    private static GroupConfiguration group(String title, String navLabel) {
        GroupConfiguration g = new GroupConfiguration();
        g.setId("doc-test-group");
        g.setTitle(title);
        g.setNavLabel(navLabel);
        return g;
    }

    // -----------------------------------------------------------------
    // navLabel takes precedence
    // -----------------------------------------------------------------

    @Test
    void resolveNavName_usesNavLabelVerbatimWhenPresent() {
        GroupConfiguration g = group("Cryptographic Key API", "Key");
        assertEquals("Key", IndexHtmlGenerator.resolveNavName(g));
    }

    @Test
    void resolveNavName_usesNavLabelEvenWhenItContainsApiSuffix() {
        // navLabel is used verbatim — no stripping
        GroupConfiguration g = group("Some API", "My Custom API Label");
        assertEquals("My Custom API Label", IndexHtmlGenerator.resolveNavName(g));
    }

    // -----------------------------------------------------------------
    // navLabel absent — fall back to title with " API" stripping
    // -----------------------------------------------------------------

    @Test
    void resolveNavName_stripsTitleApiSuffixWhenNoNavLabel() {
        GroupConfiguration g = group("Certificate Manager API", null);
        assertEquals("Certificate Manager", IndexHtmlGenerator.resolveNavName(g));
    }

    @Test
    void resolveNavName_returnsTitleUnchangedWhenNoApiSuffix() {
        GroupConfiguration g = group("Discovery", null);
        assertEquals("Discovery", IndexHtmlGenerator.resolveNavName(g));
    }

    @Test
    void resolveNavName_fallsBackToIdWhenTitleIsNull() {
        GroupConfiguration g = new GroupConfiguration();
        g.setId("doc-fallback-group");
        assertEquals("doc-fallback-group", IndexHtmlGenerator.resolveNavName(g));
    }

    // -----------------------------------------------------------------
    // blank navLabel is treated as absent
    // -----------------------------------------------------------------

    @Test
    void resolveNavName_treatsBlankNavLabelAsAbsent() {
        GroupConfiguration g = group("Token Management API", "   ");
        assertEquals("Token Management", IndexHtmlGenerator.resolveNavName(g));
    }
}
