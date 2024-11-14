
package com.ds_intelligence_arm.storage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.ds_intelligence_arm.storage.repository")
public class DatabaseConfig {
}
