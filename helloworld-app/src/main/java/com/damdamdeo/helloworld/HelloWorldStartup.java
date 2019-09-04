package com.damdamdeo.helloworld;

import io.quarkus.runtime.StartupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class HelloWorldStartup {

    @Inject
    EntityManager em;

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

    @Transactional
    void deleteInitialGift(@Observes @Priority(1) final StartupEvent ev) {
        LOGGER.info("Delete Initial GiftApp");
        em.createQuery("DELETE FROM GiftAppEntity").executeUpdate();
    }

    @Transactional
    void storeInitialGift(@Observes @Priority(2) final StartupEvent ev) {
        LOGGER.info("Store Initial GiftApp");
        final GiftAppEntity giftAppEntity = new GiftAppEntity();
        giftAppEntity.setName("Quarkus ! App");
        em.persist(giftAppEntity);
    }


}
