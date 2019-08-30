package com.damdamdeo.helloworld;

import io.quarkus.scheduler.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.CDI;

@ApplicationScoped
public class CommandHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommandHandler.class);

    @Scheduled(every="1s")
    void scheduleExecution() {
        final Boolean isResolvable = CDI.current()
                .select(Command.class).isResolvable();
        LOGGER.info("" + isResolvable);
        if (isResolvable) {
            final Command command = CDI.current()
                    .select(Command.class)
                    .get();
            command.execute();
        }
    }

}
