package com.project.impl.son;

import com.project.interfaces.Head;

public class SonHead implements Head{
    @Override
    public void think() {
        System.out.println("Son think");
    }
}
