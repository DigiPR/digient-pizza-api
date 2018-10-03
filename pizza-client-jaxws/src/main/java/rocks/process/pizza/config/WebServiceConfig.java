/*
 * Copyright (c) 2018. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.pizza.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rocks.process.pizza.api.DefaultApi;
import rocks.process.pizza.api.impl.DefaultApiServiceImplService;

@Configuration
public class WebServiceConfig {

    @Bean
    public DefaultApi defaultApi() {
        return new DefaultApiServiceImplService().getDefaultApiServiceImplPort();
    }

}
