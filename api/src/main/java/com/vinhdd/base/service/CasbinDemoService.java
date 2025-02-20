package com.vinhdd.base.service;

import lombok.RequiredArgsConstructor;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CasbinDemoService {
    private final Enforcer enforcer;

    public boolean evaluation(String sub, String obj, String act) {
        return enforcer.enforce(sub, obj, act);
    }

    public boolean addPolicy(String sub, String obj, String act) {
        return enforcer.addPolicy(sub, obj, act);
    }

    public boolean addFolder(String name, String parent){
        return enforcer.addNamedGroupingPolicy("g2", name, parent);
    }
}
