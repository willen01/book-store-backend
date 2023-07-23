package com.willen.bookStore.config;

import com.willen.bookStore.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    DbService dbService;

    @Bean // Sobe o método "instanciaBaseDeDados" quando o perfil inserido em '@Profile' estiver ativo
    public void instanciaBaseDeDados() {
        this.dbService.instanciaBaseDeDados();
    }
}
