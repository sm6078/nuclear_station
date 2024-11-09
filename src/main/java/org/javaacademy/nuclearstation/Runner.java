package org.javaacademy.nuclearstation;

import org.javaacademy.nuclearstation.subdivision.NuclearStation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.javaacademy.nuclearstation");
        NuclearStation nuclearStation = context.getBean(NuclearStation.class);
        nuclearStation.start(3);
        context.close();
    }
}
