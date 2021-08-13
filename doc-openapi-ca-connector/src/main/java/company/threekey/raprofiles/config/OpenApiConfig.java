package company.threekey.raprofiles.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class OpenApiConfig {
	
	@Autowired
	ServletContext context;
	
    @Bean
    public GroupedOpenApi caConnectorApis() {
        return GroupedOpenApi.builder()
        		.group("ca-connector")
                .packagesToScan("company.threekey.raprofiles.api.impl")
                //.pathsToMatch("/v1/**")
                .build()
                ;
    }

    @Bean
    public OpenAPI caConnectorOpenAPI() {
        Map<String, Object> logoExtension = new HashMap<>();
        Map<String, Object> logoExtensionFields = new HashMap<>();
        logoExtensionFields.put("url", "images/3keycompany.png");
        logoExtension.put("x-logo", logoExtensionFields);

        return new OpenAPI()
                .info(new Info().title("3Key RA Profiles CA Connector API")
                        .description("REST APIs for implementations of custom CA Connector")
                        .version("v0.0.1")
                        .license(new License()
                                .name("Apache License Version 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0"))
                        .extensions(logoExtension)
                        .contact(new Contact()
                                .name("3Key Company")
                                .url("https://www.3key.company")
                                .email("getinfo@3key.company")))
                .externalDocs(new ExternalDocumentation()
                        .description("3Key RA Profiles Documentation")
                        .url("https://ra-profiles.3key.company"))
                .servers(null)
                ;
    }
}
