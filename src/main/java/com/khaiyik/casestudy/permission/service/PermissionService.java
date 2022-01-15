package com.khaiyik.casestudy.permission.service;

import com.khaiyik.casestudy.permission.model.permission;

import java.util.List;
import java.util.Map;

public interface PermissionService {
    public abstract boolean addPermission(permission permission);
    public abstract Map<String, Object> checkPermission(permission permission);
    public abstract List<permission> getAllPermission();
}
