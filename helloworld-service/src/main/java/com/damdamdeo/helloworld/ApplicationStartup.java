package com.damdamdeo.helloworld;

import io.quarkus.runtime.StartupEvent;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class ApplicationStartup {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStartup.class);

    @Inject
    EntityManager em;

    @Inject
    Flyway flyway;

    void startup(@Observes @Priority(1) final StartupEvent ev) {
        LOGGER.info("ApplicationStartup");
        flyway.migrate();
        LOGGER.info(flyway.info().current().getVersion().toString());
    }

    @Transactional
    void deleteInitialGift(@Observes @Priority(2) final StartupEvent ev) {
        LOGGER.info("Delete Initial Gift");
        em.createQuery("DELETE FROM GiftEntity").executeUpdate();
    }

    @Transactional
    void storeInitialGift(@Observes @Priority(3) final StartupEvent ev) {
        LOGGER.info("Store Initial Gift");
        final GiftEntity giftEntity = new GiftEntity();
        giftEntity.setName("Quarkus !");
        em.persist(giftEntity);
    }

}
