package com.project.config;

import com.project.impl.rob.ModT1000;
import com.project.impl.son.SonHand;
import com.project.impl.son.SonHead;
import com.project.impl.son.SonLeg;
import com.project.impl.tosh.ToshHand;
import com.project.impl.tosh.ToshHead;
import com.project.impl.tosh.ToshLeg;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringContext {
    @Bean
    public ModT1000 getModT1000() {
        ModT1000 modT1000 = new ModT1000();
        modT1000.setHead(getToshHead());
        modT1000.setHand(getSonHand());
        modT1000.setLeg(getToshLeg());
        modT1000.setColor("red");
        modT1000.setYear(233);
        modT1000.setSoundEnable(true);
        return modT1000;
    }

    @Bean
    public ModT1000 getModT1000Empty() {
        ModT1000 modT1000 = new ModT1000(getToshHead(),getSonHand(),getSonLeg());
        return modT1000;
    }



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
