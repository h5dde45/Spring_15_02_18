package com.project.impl.rob;

import com.project.interfaces.Hand;
import com.project.interfaces.Head;
import com.project.interfaces.Leg;
import com.project.interfaces.Rob;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class ModT1000 implements Rob, InitializingBean, DisposableBean {

    @Qualifier("getSonHead")
    @Autowired
    private Head head;
    @Qualifier("getToshHand")
    @Autowired
    private Hand hand;
    @Qualifier("getToshLeg")
    @Autowired
    private Leg leg;

    private String color;
    private int year;
    private boolean soundEnable;

    public ModT1000() {
    }

    public ModT1000(Head head, Hand hand, Leg leg) {
        this.head = head;
        this.hand = hand;
        this.leg = leg;
    }

    public ModT1000(String color, int year, boolean soundEnable) {
        this.color = color;
        this.year = year;
        this.soundEnable = soundEnable;
    }

    public ModT1000(Head head, Hand hand, Leg leg, String color, int year, boolean soundEnable) {
        this.head = head;
        this.hand = hand;
        this.leg = leg;
        this.color = color;
        this.year = year;
        this.soundEnable = soundEnable;
    }

    public Head getHead() {
        return head;
    }

    @Required
    public void setHead(Head head) {
        this.head = head;
    }

    public Hand getHand() {
        return hand;
    }

    @Required
    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Leg getLeg() {
        return leg;
    }

    @Required
    public void setLeg(Leg leg) {
        this.leg = leg;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isSoundEnable() {
        return soundEnable;
    }

    public void setSoundEnable(boolean soundEnable) {
        this.soundEnable = soundEnable;
    }

    @Override
    public void action() {
        head.think();
        hand.take();
        leg.go();
        System.out.println(color);
        System.out.println(year);
        System.out.println(soundEnable);
    }

    @Override
    public void secondAction() {
        System.out.println("T1000 do secondAction");
    }

//    public void initObject() {
//        System.out.println("init");
//    }
//
//    public void destroyObject() {
//        System.out.println("destroy");
//    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this + " - destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this + " - init()");
    }
}
