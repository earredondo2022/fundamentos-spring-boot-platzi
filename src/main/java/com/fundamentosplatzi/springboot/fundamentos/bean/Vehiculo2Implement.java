package com.fundamentosplatzi.springboot.fundamentos.bean;

public class Vehiculo2Implement implements Vehiculo{

    private Mover mover;

    public Vehiculo2Implement(Mover mover) {
        this.mover = mover;
    }

    @Override
    public void add() {
        System.out.println("add vehiculo");
    }

    @Override
    public void delete() {
        System.out.println("delete vehiculo");
        mover.right();
        mover.right();
    }

    @Override
    public void update() {
        System.out.println("update vehiculo");
        mover.left();
        mover.left();

    }
}
