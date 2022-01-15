package com.khaiyik.casestudy.permission.controller;

import com.khaiyik.casestudy.permission.model.permission;
import com.khaiyik.casestudy.permission.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @GetMapping("/")
    public String index() {
        return "hello world";
    }

    @GetMapping("/feature")
    public Map<String, Object> checkPermission(@RequestParam(name="email") String email,@RequestParam(name="permission") String permName) {
        permission searchObj = new permission();
        searchObj.setPermission(permName);
        searchObj.setEmail(email);
        return permissionService.checkPermission(searchObj);
    }

    @GetMapping("/permissions")
    public List<permission> getPermissions() {
            return permissionService.getAllPermission();
    }

    @PostMapping("/feature")
    public ResponseEntity<Object> modPermission(@RequestBody permission params) {

        if (permissionService.addPermission(params))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}