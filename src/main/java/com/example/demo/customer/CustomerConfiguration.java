package com.example.demo.customer;

import com.example.demo.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CustomerConfiguration {
    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Value("${info.application.name}")
    private String appName;
    @Autowired
    private Environment environment;

    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp) {
        return args -> {
            System.out.println("Command line runner...");
            System.out.println("Application name: " + appName );
            String appVersion = environment.getProperty("info.application.version");
            System.out.println("Version: " + appVersion);
            System.out.println(infoApp);
        };
    }

    /*@Bean
    CustomerRepo customerRepo() {
        System.out.println("useFakeCustomerRepo: " + useFakeCustomerRepo);
        return useFakeCustomerRepo ?
                new CustomerFakeRepository() :
                new CustomerRepository();
    }*/

    @Bean
    CustomerRepo customerRepo() {
        System.out.println("useFakeCustomerRepo: " + useFakeCustomerRepo);
        return new CustomerFakeRepository();
    }
}
