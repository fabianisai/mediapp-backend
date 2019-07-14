package com.fabianisai.mediappbackend;

import com.fabianisai.mediappbackend.model.Usuario;
import com.fabianisai.mediappbackend.repo.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MediappBackendApplication {


    public static void main(String[] args) {



        SpringApplication.run(MediappBackendApplication.class, args);
    }

}




