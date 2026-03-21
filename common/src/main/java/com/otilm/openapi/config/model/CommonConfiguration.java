package com.otilm.openapi.config.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Model class representing common configuration elements from groups.yaml
 */
public class CommonConfiguration {
    private LogoConfiguration logo;
    private LicenseConfiguration license;
    private ContactConfiguration contact;
    private ExternalDocsConfiguration externalDocs;
    private List<ServerConfiguration> servers = Collections.emptyList();
    private Map<String, Object> extensions = Collections.emptyMap();

    public LogoConfiguration getLogo() {
        return logo;
    }

    public void setLogo(LogoConfiguration logo) {
        this.logo = logo;
    }

    public LicenseConfiguration getLicense() {
        return license;
    }

    public void setLicense(LicenseConfiguration license) {
        this.license = license;
    }

    public ContactConfiguration getContact() {
        return contact;
    }

    public void setContact(ContactConfiguration contact) {
        this.contact = contact;
    }

    public ExternalDocsConfiguration getExternalDocs() {
        return externalDocs;
    }

    public void setExternalDocs(ExternalDocsConfiguration externalDocs) {
        this.externalDocs = externalDocs;
    }

    public List<ServerConfiguration> getServers() {
        return servers;
    }

    public void setServers(List<ServerConfiguration> servers) {
        if (servers != null) {
            this.servers = Collections.unmodifiableList(servers);
        }
    }

    public Map<String, Object> getExtensions() {
        return extensions;
    }

    public void setExtensions(Map<String, Object> extensions) {
        if (extensions != null) {
            this.extensions = Collections.unmodifiableMap(extensions);
        }
    }

    public static class LogoConfiguration {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class LicenseConfiguration {
        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class ContactConfiguration {
        private String name;
        private String url;
        private String email;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public static class ExternalDocsConfiguration {
        private String description;
        private String url;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class ServerConfiguration {
        private String url;
        private String description;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
