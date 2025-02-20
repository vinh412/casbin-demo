package com.vinhdd.base.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthorizationService implements CommandLineRunner {
    private final Enforcer enforcer;

    public void addPolicy() {
        log.info("Add policy");
        log.info("{}", enforcer.addNamedGroupingPolicy("g", "sontn", "group1"));
        log.info("{}", enforcer.addNamedGroupingPolicy("g", "hieutt", "group1"));
        log.info("{}", enforcer.addNamedGroupingPolicy("g", "vinhdd", "group2"));

        log.info("{}", enforcer.addNamedGroupingPolicy("g2", "devops", "htdll"));
        log.info("{}", enforcer.addNamedGroupingPolicy("g2", "python", "htdll"));
        log.info("{}", enforcer.addNamedGroupingPolicy("g2", "java", "htdll"));
        log.info("{}", enforcer.addNamedGroupingPolicy("g2", "project1", "java"));
        log.info("{}", enforcer.addNamedGroupingPolicy("g2", "project2", "java"));

        log.info("{}", enforcer.addNamedGroupingPolicy("g3", "[GET]/java", "admin"));
        log.info("{}", enforcer.addNamedGroupingPolicy("g3", "[POST]/java", "admin"));
        log.info("{}", enforcer.addNamedGroupingPolicy("g3", "[GET]/java", "user"));


        log.info("{}", enforcer.addPolicy("group1", "java", "java-leader"));
        log.info("{}", enforcer.addPolicy("sontn2", "java", "java-leader"));

        enforcer.savePolicy();
        log.info("Add policy");
    }

    @Scheduled()
    public void enforce(){
        log.info("Enforce");
        log.info("{}", enforcer.enforce("sontn", "java", "[GET]/java"));
        log.info("{}", enforcer.enforce("sontn", "sub-project1", "DELETE"));
        log.info("{}", enforcer.enforce("sontn", "project1", "DELETE"));
        log.info("{}", enforcer.enforce("hieutt", "project2", "GET"));
        log.info("{}", enforcer.enforce("hieutt", "htdll", "GET"));
        log.info("{}", enforcer.enforce("hieutt", "java", "GET"));
        log.info("Enforce");
    }

    @Override
    public void run(String... args) {
//        addPolicy();
//        enforce();
        log.info("htdll: {}", enforcer.getNamedRoleManager("g2").getRoles("project1"));
    }
}
