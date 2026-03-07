package com.czertainly.openapi.config.model;

/**
 * Model class representing common configuration elements
 */
public class CommonConfiguration {
    private LogoConfiguration logo;
    private LicenseConfiguration license;
    private ContactConfiguration contact;
    private ExternalDocsConfiguration externalDocs;
    private java.util.List<ServerConfiguration> servers;
    private java.util.Map<String, Object> extensions;

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

    public java.util.List<ServerConfiguration> getServers() {
        return servers;
    }

    public void setServers(java.util.List<ServerConfiguration> servers) {
        this.servers = servers;
    }

    public java.util.Map<String, Object> getExtensions() {
        return extensions;
    }

    public void setExtensions(java.util.Map<String, Object> extensions) {
        this.extensions = extensions;
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
