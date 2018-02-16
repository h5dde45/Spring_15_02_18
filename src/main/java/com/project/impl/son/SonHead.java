package com.project.impl.son;

import com.project.interfaces.Head;
import org.springframework.stereotype.Component;

@Component
public class SonHead implements Head{
    @Override
    public void think() {
        System.out.println("Son think");
    }
}
