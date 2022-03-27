package com.fundamentosplatzi.springboot.fundamentos.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "user") /** Se trae la información declarada en: application.properties */
public class UserPojo {
    private String correo;
    private String clave;
    private int edad;

    public UserPojo(String correo, String clave, int edad) {
        this.correo = correo;
        this.clave = clave;
        this.edad = edad;
    }

    public String getCorreo(){
        return correo;
    }

    public String getClave(){
        return clave;
    }

    public int getEdad(){
        return edad;
    }

}
