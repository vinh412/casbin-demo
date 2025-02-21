package com.vinhdd.base.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitSampleDataService implements CommandLineRunner {
    private final Enforcer enforcer;

    public void initSampleData() {
        log.info("Init sample data");
        // add user to group
        log.info("{}", enforcer.addNamedGroupingPolicy("g", "vinhdd", "java-fresher-group"));

        // add decentralized data
        log.info("{}", enforcer.addNamedGroupingPolicy("g2", "devops", "htdll"));
        log.info("{}", enforcer.addNamedGroupingPolicy("g2", "python", "htdll"));
        log.info("{}", enforcer.addNamedGroupingPolicy("g2", "java", "htdll"));
        log.info("{}", enforcer.addNamedGroupingPolicy("g2", "project1", "java"));
        log.info("{}", enforcer.addNamedGroupingPolicy("g2", "project2", "java"));

        // add permission to role
        log.info("{}", enforcer.addNamedGroupingPolicy("g3", "GET", "admin"));
        log.info("{}", enforcer.addNamedGroupingPolicy("g3", "POST", "admin"));
        log.info("{}", enforcer.addNamedGroupingPolicy("g3", "PUT", "admin"));
        log.info("{}", enforcer.addNamedGroupingPolicy("g3", "DELETE", "admin"));
        log.info("{}", enforcer.addNamedGroupingPolicy("g3", "GET", "fresher"));

        // add policy
        log.info("{}", enforcer.addPolicy("hieutt", "java", "admin"));
        log.info("{}", enforcer.addPolicy("sontn", "htdll", "admin"));
        log.info("{}", enforcer.addPolicy("java-fresher-group", "java", "fresher"));

        enforcer.savePolicy();
    }

    public void enforce(){
        log.info("Enforce");
        log.info("{}", enforcer.enforce("sontn", "java", "GET"));
        log.info("{}", enforcer.enforce("sontn", "htdll", "POST"));
    }

    @Override
    public void run(String... args) {
        initSampleData();
        enforce();
    }
}
