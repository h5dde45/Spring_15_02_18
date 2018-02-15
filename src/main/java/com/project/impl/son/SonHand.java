package com.project.impl.son;

import com.project.interfaces.Hand;

public class SonHand implements Hand {
    @Override
    public void take() {
        System.out.println("Son take");
    }
}
