package com.fundamentosplatzi.springboot.fundamentos.bean;

public class VehiculoImplement implements Vehiculo{

    private Mover mover;

    public VehiculoImplement(Mover mover) {
        this.mover = mover;
    }

    @Override
    public void add() {
        System.out.println("add vehiculo");
        mover.left();
    }

    @Override
    public void delete() {
        System.out.println("delete vehiculo");
        mover.right();
    }

    @Override
    public void update() {
        System.out.println("update vehiculo");
        mover.left();
        mover.right();
    }
}
