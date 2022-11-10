package com.czertainly.config;

import com.czertainly.api.model.common.attribute.v2.BaseAttribute;
import com.czertainly.api.model.core.connector.FunctionGroupCode;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class OpenApiConfig {
	
	@Autowired
	ServletContext context;

    @Value( "${api.version}" )
    private String version;
	
    @Bean
    public GroupedOpenApi connectorApis() {
        return GroupedOpenApi.builder()
        		.group("core-connector")
                .packagesToScan("com.czertainly.api.impl")
                //.pathsToMatch("/v1/**")
                .build()
                ;
    }

    @Bean
    public OpenAPI connectorOpenAPI() {
        Map<String, Object> logoExtension = new HashMap<>();
        Map<String, Object> logoExtensionFields = new HashMap<>();
        logoExtensionFields.put("url", "images/czertainly_color_H.svg");
        logoExtension.put("x-logo", logoExtensionFields);

//        Schema<Map<String, List<BaseAttribute>>> innerSchema = new Schema<Map<String, List<BaseAttribute>>>();
//        innerSchema.setAdditionalProperties(new ArraySchema());
//
//        Schema<Map<FunctionGroupCode, Map<String, List<BaseAttribute>>>> outerSchema = new Schema<Map<FunctionGroupCode, Map<String, List<BaseAttribute>>>>();
//        outerSchema.setAdditionalProperties(innerSchema);

        return new OpenAPI()
                .info(new Info().title("CZERTAINLY Connector API")
                        .description("REST API for managing Connectors in the platform")
                        .license(new License()
                                .name("MIT License")
                                .url("https://github.com/3KeyCompany/CZERTAINLY/blob/develop/LICENSE.md"))
                        .extensions(logoExtension)
                        .contact(new Contact()
                                .name("CZERTAINLY")
                                .url("https://www.czertainly.com")
                                .email("getinfo@czertainly.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("CZERTAINLY Documentation")
                        .url("https://docs.czertainly.com"))
                .servers(null)
//                .components(new Components().addSchemas("AttributesMap", outerSchema))
                ;
    }

}
