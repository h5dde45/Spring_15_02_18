package com.project.config;

import com.project.impl.conveyor.T1000Conveyor;
import com.project.impl.rob.ModT1000;
import com.project.interfaces.Hand;
import com.project.interfaces.Head;
import com.project.interfaces.Leg;
import com.project.interfaces.Rob;
import com.project.main.NewBeanPostProcessor;
import org.springframework.context.annotation.*;

@Configuration
@Import({ToshContext.class,SonContext.class,DbContext.class})
@Lazy
public class SpringContext {
    @Bean
    @Scope("prototype")
//    @DependsOn({"getModT1000Empty","db"})
    public ModT1000 getModT1000(/*ToshHead toshHead, SonHand sonHand, ToshLeg toshLeg*/) {
        ModT1000 modT1000 = new ModT1000();
//        modT1000.setHead(toshHead);
//        modT1000.setHand(sonHand);
//        modT1000.setLeg(toshLeg);
//        modT1000.setColor("red");
//        modT1000.setYear(233);
//        modT1000.setSoundEnable(true);
        return modT1000;
    }

//    @Bean
    public ModT1000 getModT1000Parent(Head head,Hand hand,Leg leg) {
        ModT1000 modT1000 =
                new ModT1000(head,hand,leg);
        return modT1000;
    }
    @Bean
    public ModT1000 getModT1000Empty() {
        ModT1000 modT1000 =
                new ModT1000();
        return modT1000;
    }

    @Bean
    public NewBeanPostProcessor getNewBeanPostProcessor(){
        return new NewBeanPostProcessor();
    }

    @Bean(name = "t1000Conveyor")
    public T1000Conveyor getT1000Conveyor(){
        return new T1000Conveyor() {
            @Override
            public Rob createRob() {
                return getModT1000Empty();
            }
        };
    }

}
