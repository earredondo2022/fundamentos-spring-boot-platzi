package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {

        LOGGER.info("Pasando por el metodo: printWithDependency");
        int number = 2;
        LOGGER.debug("numero ingresado como parametro a la dependencia operation es: " + number);
        System.out.println("Number: " + myOperation.sum(number));
        System.out.println("Hola desde la implementación de un bean con dependencia");
    }
}
