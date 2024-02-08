package ru.kndmnet.netapigate.task;

import reactor.core.publisher.Mono;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Thread.sleep;

public abstract class InnerApiCallTask<Rq, Rs> implements Callable<Rs> {

    private final Mono<Rq> requestDto;

    public InnerApiCallTask(Mono<Rq> requestDto) {
        this.requestDto = requestDto;
    }

    @Override
    public Rs call() throws Exception {
        AtomicReference<Rs> regRequestDtoAtomicReference = new AtomicReference<>();
        AtomicBoolean executed = new AtomicBoolean(false);
        requestDto.subscribe(dto -> {
            regRequestDtoAtomicReference.set(getResponseDto(dto));
            executed.set(true);
        });
        while (!executed.get()) {
            sleep(20);
        }
        return regRequestDtoAtomicReference.get();
    }

    public abstract Rs getResponseDto(Rq dto);
}