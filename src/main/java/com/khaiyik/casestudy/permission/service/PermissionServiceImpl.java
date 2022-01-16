package com.khaiyik.casestudy.permission.service;

import com.khaiyik.casestudy.permission.model.permissions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {
    private static List<permissions> permissionsList = new ArrayList<>();
    static {
        permissionsList.add(new permissions("payroll","hr@mail.com",true));
        permissionsList.add(new permissions("payment","fin@mail.com",true));
        permissionsList.add(new permissions("payroll","fin@mail.com",false));
        permissionsList.add(new permissions("payment","hr@mail.com",false));
    }
    @Override
    public boolean addPermissions(permissions permissions) {

        boolean isExe = createUpdate(permissions);
        return isExe;
    }
    @Override
    public List<permissions> getAllPermissions() {
        return permissionsList;
    }
    @Override
    public Map<String, Object> checkPermissions(permissions permissions) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("canAccess", getPermissions(permissions));
        return map;
    }

    private boolean createUpdate(permissions p){
        boolean isOperate = true;
        boolean executed = false;

        for (int i = 0; i < permissionsList.size(); i++) {
            if (permissionsList.get(i).getFeatureName().equals(p.getFeatureName()) && permissionsList.get(i).getEmail().equals(p.getEmail())){
                if (permissionsList.get(i).isEnable() == p.isEnable()){
                    isOperate = false;
                    break;
                }
                else{
                    executed = true;
                    permissionsList.get(i).setEnable(p.isEnable());
                    break;
                }
            }
        }

        if(isOperate && !executed){
            permissionsList.add(p);
        }
        return isOperate;
    }

    private boolean getPermissions(permissions p)
    {
        boolean isPmsEnb = false;

        for (int i = 0; i < permissionsList.size(); i++) {
            if (permissionsList.get(i).getFeatureName().equals(p.getFeatureName()) && permissionsList.get(i).getEmail().equals(p.getEmail())){
                isPmsEnb = permissionsList.get(i).isEnable();
            }
        }
        return isPmsEnb;
    }

}
