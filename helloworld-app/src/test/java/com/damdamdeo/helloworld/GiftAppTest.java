package com.damdamdeo.helloworld;

import io.quarkus.test.junit.QuarkusTest;
import org.hibernate.envers.AuditReaderFactory;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class GiftAppTest {

    @Inject
    EntityManager em;

    @Test
    public void should_store_gift_app_on_init() {
        final List<GiftAppEntity> giftAppEntities = em.createQuery("SELECT g FROM GiftAppEntity g").getResultList();
        assertThat(giftAppEntities.size()).isEqualTo(1);

        final List<GiftAppEntity> giftAppsAudited = AuditReaderFactory.get(em)
                .createQuery()
                .forRevisionsOfEntity(GiftAppEntity.class, true, true)
                .getResultList();
        // dumb test has database may not be reset between each launch
        // I just want to know that envers does not fail
        assertThat(giftAppsAudited.size()).isGreaterThan(0);
    }

    @Test
    public void should_store_gift_on_init() {
        final List<GiftEntity> giftEntities = em.createQuery("SELECT g FROM GiftEntity g").getResultList();
        assertThat(giftEntities.size()).isEqualTo(1);

        final List<GiftEntity> giftsAudited = AuditReaderFactory.get(em)
                .createQuery()
                .forRevisionsOfEntity(GiftEntity.class, true, true)
                .getResultList();
        // dumb test has database may not be reset between each launch
        // I just want to know that envers does not fail
        assertThat(giftsAudited.size()).isGreaterThan(0);
    }

}
