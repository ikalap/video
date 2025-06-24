package com.kalpa.video.demo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import io.micrometer.core.instrument.config.MeterFilter;
import io.micrometer.core.instrument.config.MeterFilterReply;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo1 {
    public static void main(String[] args) {
        MeterRegistry registry = new SimpleMeterRegistry();

        Counter counter = registry.counter("kalpa.couter");
        for (int i = 0; i < 10; i++) {
            counter.increment();
        }

        // maintain a reference to myGauge
        AtomicInteger myGauge = registry.gauge("numberGauge", new AtomicInteger(0));

        // ... elsewhere you can update the value it holds using the object reference
        myGauge.set(27);
        myGauge.set(11);

    }


}
