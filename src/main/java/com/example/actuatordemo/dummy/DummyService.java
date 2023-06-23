package com.example.actuatordemo.dummy;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class DummyService {

    @SneakyThrows
    public void doSomething() {
        Random random = new Random();
        int time = random.nextInt(2_000);

        log.info("Sleep start");
        Thread.sleep(time);
        log.info("Sleep end");
    }

}
