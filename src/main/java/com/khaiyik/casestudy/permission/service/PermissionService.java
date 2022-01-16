package com.khaiyik.casestudy.permission.service;

import com.khaiyik.casestudy.permission.model.permissions;

import java.util.List;
import java.util.Map;

public interface PermissionService {
    public abstract boolean addPermissions(permissions permissions);
    public abstract Map<String, Object> checkPermissions(permissions permissions);
    public abstract List<permissions> getAllPermissions();
}
