package com.khaiyik.casestudy.permission.service;

import com.khaiyik.casestudy.permission.model.permission;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {
    private static List<permission> permissionList = new ArrayList<>();
    static {
        permissionList.add(new permission("payroll","hr@mail.com",true));
        permissionList.add(new permission("payment","fin@mail.com",true));
        permissionList.add(new permission("payroll","fin@mail.com",false));
        permissionList.add(new permission("payment","hr@mail.com",false));
    }
    @Override
    public boolean addPermission(permission permission) {

        boolean isExe = createUpdate(permission);
        return isExe;
    }
    @Override
    public List<permission> getAllPermission() {
        return permissionList;
    }
    @Override
    public Map<String, Object> checkPermission(permission permission) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("canAccess", getPermission(permission));
        return map;
    }

    private boolean createUpdate(permission p){
        boolean isOperate = true;
        boolean executed = false;

        for (int i = 0;i < permissionList.size();i++) {
            if (permissionList.get(i).getPermission().equals(p.getPermission()) && permissionList.get(i).getEmail().equals(p.getEmail())){
                if (permissionList.get(i).isEnable() == p.isEnable()){
                    isOperate = false;
                    break;
                }
                else{
                    executed = true;
                    permissionList.get(i).setEnable(p.isEnable());
                    break;
                }
            }
        }

        if(isOperate && !executed){
            permissionList.add(p);
        }
        return isOperate;
    }

    private boolean getPermission(permission p)
    {
        boolean isPmsEnb = false;

        for (int i = 0;i < permissionList.size();i++) {
            if (permissionList.get(i).getPermission().equals(p.getPermission()) && permissionList.get(i).getEmail().equals(p.getEmail())){
                isPmsEnb = permissionList.get(i).isEnable();
            }
        }
        return isPmsEnb;
    }

}
