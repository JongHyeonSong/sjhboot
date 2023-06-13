package com.example.sjhboot.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;

// spring boot 2.6이상은 properties에 아래 설정
// spring.mvc.pathmatch.matching-strategy=ant_path_matcher
@Configuration
public class SwaggerConfig {

	private String baseUrl = "localhost:8080";

	@Bean
	public Docket dockk() {
		// TypeResolver resolver
		TypeResolver resolver = new TypeResolver();
		Docket dd = new Docket(DocumentationType.SWAGGER_2);

		Set<String> cosums = new HashSet<>();
		cosums.add("application/json;charset=UTF-8");
		dd.consumes(cosums);

		Set<String> produce = new HashSet<>();
		produce.add("application/json;charset=UTF-8");
		dd.produces(cosums);

		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		apiInfoBuilder.title("인포 title");
		apiInfoBuilder.description("<bold>인포 디스크립션</bold>");
		apiInfoBuilder.version("9922");
		dd.apiInfo(apiInfoBuilder.build());

		// dd.additionalModels(resolver.resolve(ResponseEntity.class));

		ApiSelectorBuilder ddSelector = dd.select();

		ddSelector.apis(RequestHandlerSelectors.basePackage("com.example.sjhboot"));
		ddSelector.paths(PathSelectors.any());

		dd.useDefaultResponseMessages(false);
		dd.host(baseUrl);

		return dd;
	}
}

/**
 * package com.realcastle.config;
 * 
 * import java.util.HashSet;
 * import java.util.Set;
 * 
 * import org.springframework.context.annotation.Bean;
 * import org.springframework.context.annotation.Configuration;
 * import org.springframework.context.annotation.Profile;
 * 
 * import com.fasterxml.classmate.TypeResolver;
 * 
 * import springfox.documentation.builders.ApiInfoBuilder;
 * import springfox.documentation.builders.PathSelectors;
 * import springfox.documentation.builders.RequestHandlerSelectors;
 * import springfox.documentation.service.ApiInfo;
 * import springfox.documentation.spi.DocumentationType;
 * import springfox.documentation.spring.web.plugins.Docket;
 * 
 * @Profile("!prd")
 * 
 * @Configuration
 *                public class SwaggerConfiguration {
 * @Bean
 *       public Docket realcastleApi(TypeResolver resolver) {
 *       return new
 *       Docket(DocumentationType.SWAGGER_2).consumes(getConsumeContentTypes())
 *       .produces(getProduceContentTypes()).apiInfo(realcastleAPIInfo()).select()
 *       .apis(RequestHandlerSelectors.basePackage("com.realcastle")).paths(PathSelectors.any()).build()
 *       .useDefaultResponseMessages(false);
 *       }
 * 
 *       private Set<String> getConsumeContentTypes() {
 *       Set<String> consumes = new HashSet<>();
 *       consumes.add("application/json;charset=UTF-8");
 *       return consumes;
 *       }
 * 
 *       private Set<String> getProduceContentTypes() {
 *       Set<String> produces = new HashSet<>();
 *       produces.add("application/json;charset=UTF-8");
 *       return produces;
 *       }
 * 
 *       private ApiInfo realcastleAPIInfo() {
 *       return new ApiInfoBuilder().title("realcastle
 *       API").description("<span >real castle API</span><br/>
 *       ")
 *       .version("1.0").build();
 *       }
 *       }
 * 
 */