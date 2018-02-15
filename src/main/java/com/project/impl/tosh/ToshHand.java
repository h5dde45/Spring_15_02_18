package com.project.impl.tosh;

import com.project.interfaces.Hand;

public class ToshHand implements Hand {
    @Override
    public void take() {
        System.out.println("Tosh take");
    }
}
