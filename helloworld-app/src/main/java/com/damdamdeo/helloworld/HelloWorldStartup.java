package com.damdamdeo.helloworld;

import io.quarkus.runtime.StartupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.CDI;

@ApplicationScoped
public class HelloWorldStartup {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldStartup.class);

    void startup(@Observes final StartupEvent ev) {
        final Boolean isResolvable = CDI.current()
                .select(HelloWorldService.class).isResolvable();
        LOGGER.info("" + isResolvable);
        final HelloWorldService helloWorldService = CDI.current()
                .select(HelloWorldService.class)
                .get();
        LOGGER.info(helloWorldService.sayHello());
    }

    // TODO consumer KAFKA dans l'external jar ... utiliser un test pour produire un event dans kafka
    // TODO tester en native
    // si tout est ok alors bingo



}
