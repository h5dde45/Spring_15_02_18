package com.project.impl.conveyor;

import com.project.interfaces.Rob;
import com.project.interfaces.RobConveyor;

public abstract class T1000Conveyor implements RobConveyor {
    @Override
    public abstract Rob createRob();
}
