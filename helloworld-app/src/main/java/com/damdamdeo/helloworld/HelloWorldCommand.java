package com.damdamdeo.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloWorldCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldCommand.class);

    @Override
    public void execute() {
        LOGGER.info("HelloWorldCommand");
    }

}
