package com.fundamentosplatzi.springboot.fundamentos.configuration;

import com.fundamentosplatzi.springboot.fundamentos.bean.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return  new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperation2(){
        return  new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanWithDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }

    @Bean
    public Mover beanMover(){
        return new MoverImplement();
    }

    @Bean
    public Vehiculo beanVehiculo(Mover mover){
        return new Vehiculo2Implement(mover);
    }
}
