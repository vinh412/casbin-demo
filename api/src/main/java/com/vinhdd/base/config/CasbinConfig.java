package com.vinhdd.base.config;

import lombok.RequiredArgsConstructor;
import org.casbin.adapter.JDBCAdapter;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class CasbinConfig {
    private final DataSource dataSource;

    @Bean
    public Enforcer enforcer() throws Exception {

        JDBCAdapter a = new JDBCAdapter(dataSource);

        String modelPath = "src/main/resources/model.conf";

        Enforcer enforcer = new Enforcer(modelPath, a);
        enforcer.enableAutoSave(true);

        return enforcer;
    }
}