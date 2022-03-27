package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyBeanWithParameterImplement implements MyBeanWithParameter{

    private String nombre;
    private String apellido;

    public MyBeanWithParameterImplement(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public void print() {
        System.out.println("Nombre: " + nombre + " Apellido: " + apellido);
    }

    @Override
    public String function() {
        return nombre + " " + apellido;
    }
}
