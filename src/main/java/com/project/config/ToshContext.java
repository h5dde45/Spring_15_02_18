package com.project.config;

import com.project.impl.tosh.ToshHand;
import com.project.impl.tosh.ToshHead;
import com.project.impl.tosh.ToshLeg;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class ToshContext {
    @Bean
    public ToshHead getToshHead() {
        return new ToshHead();
    }

    @Bean
    public ToshHand getToshHand() {
        return new ToshHand();
    }

    @Bean
    public ToshLeg getToshLeg() {
        return new ToshLeg();
    }
}
