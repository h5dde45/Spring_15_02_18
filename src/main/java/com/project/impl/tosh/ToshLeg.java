package com.project.impl.tosh;

import com.project.interfaces.Leg;

public class ToshLeg implements Leg {
    @Override
    public void go() {
        System.out.println("Tosh go");
    }
}
