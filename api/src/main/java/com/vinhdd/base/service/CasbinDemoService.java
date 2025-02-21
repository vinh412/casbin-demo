package com.vinhdd.base.service;

import lombok.RequiredArgsConstructor;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CasbinDemoService {
    private final Enforcer enforcer;

    public boolean evaluation(String sub, String obj, String endpoint) {
        return enforcer.enforce(sub, obj, endpoint);
    }

    public boolean addPolicy(String sub, String obj, String role) {
        return enforcer.addPolicy(sub, obj, role);
    }

    public boolean addFolder(String name, String parent){
        return enforcer.addNamedGroupingPolicy("g2", name, parent);
    }

    public boolean addUserToGroup(String user, String group){
        return enforcer.addNamedGroupingPolicy("g", user, group);
    }

    public boolean addPermissionToRole(String permission, String role){
        return enforcer.addNamedGroupingPolicy("g3", permission, role);
    }

    public List<String> getAllChildrenOfParent(String ptype, String parent){
        return enforcer.getNamedRoleManager(ptype).getUsers(parent);
    }

    public List<String> getAllParentOfChild(String ptype, String child){
        return enforcer.getNamedRoleManager(ptype).getRoles(child);
    }

    public Map<String, Object> getTree(String ptype, String name){
        Map<String, Object> tree = new HashMap<>();
        tree.put("name", name);
        List<String> children = getAllChildrenOfParent(ptype, name);
        List<Map<String, Object>> childrenTree = children.stream().map(child -> getTree(ptype, child)).toList();
        tree.put("children", childrenTree);
        return tree;
    }
}
