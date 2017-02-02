package com.lukedeighton.wheelsample.model;

import java.io.Serializable;

public class WheelListMain implements Serializable {
    public String wheelName;
    public  int wheelImageID;

    public WheelListMain(String wheelName, int wheelImageID) {
        this.wheelName = wheelName;
        this.wheelImageID = wheelImageID;
    }

    public String getWheelName() {
        return wheelName;
    }

    public void setWheelName(String wheelName) {
        this.wheelName = wheelName;
    }

    public int getWheelImageID() {
        return wheelImageID;
    }

    public void setWheelImageID(int wheelImageID) {
        this.wheelImageID = wheelImageID;
    }
}
