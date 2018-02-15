package com.project.impl.son;

import com.project.interfaces.Leg;

public class SonLeg implements Leg {
    @Override
    public void go() {
        System.out.println("Son Leg");
    }
}
