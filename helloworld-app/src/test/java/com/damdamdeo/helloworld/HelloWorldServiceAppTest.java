package com.damdamdeo.helloworld;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class HelloWorldServiceAppTest {

    @Inject
    HelloWorldService helloWorldService;

    @Test
    public void should_say_hello() {
        assertThat(helloWorldService.sayHello()).isEqualTo("Hello");
    }

}
