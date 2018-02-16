package com.project.impl.son;

import com.project.interfaces.Hand;
import org.springframework.stereotype.Component;

@Component
public class SonHand implements Hand {
    @Override
    public void take() {
        System.out.println("Son take");
    }
}
