package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MoverImplement implements Mover{
    @Override
    public void left() {
        System.out.println("mover a la izquierda.");
    }

    @Override
    public void right() {
        System.out.println("mover a la derecha");
    }
}
