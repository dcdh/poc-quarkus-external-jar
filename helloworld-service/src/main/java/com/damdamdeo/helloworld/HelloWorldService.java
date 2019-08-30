package com.damdamdeo.helloworld;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloWorldService {

    public String sayHello() {
        return "Hello";
    }

}
