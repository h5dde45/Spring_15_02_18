package com.project.config;

import com.project.impl.son.SonHand;
import com.project.impl.son.SonHead;
import com.project.impl.son.SonLeg;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class SonContext {

    @Bean
    public SonHead getSonHead() {
        return new SonHead();
    }

    @Bean
    public SonHand getSonHand() {
        return new SonHand();
    }

    @Bean
    public SonLeg getSonLeg() {
        return new SonLeg();
    }
}
