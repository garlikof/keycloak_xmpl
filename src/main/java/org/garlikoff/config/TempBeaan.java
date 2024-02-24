package org.garlikoff.config;

import lombok.extern.slf4j.Slf4j;
import org.garlikoff.model.AbstractInterface;
import org.garlikoff.model.UniversalTransport;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TempBeaan implements AbstractInterface {
    @Override
    public void run(UniversalTransport body) {
        log.info(">>>> temp");
    }

    @Bean(name = "temp")
    public TempBeaan getBean(){
        return new TempBeaan();
    }
}
