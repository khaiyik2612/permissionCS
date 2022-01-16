package com.khaiyik.casestudy.permission.controllers;

import com.khaiyik.casestudy.permission.model.permission;
import com.khaiyik.casestudy.permission.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "Permission Command", value = "Permission Commands", description = "Controller for Permission Commands")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @ApiOperation(value = "This method is used to redirect to vcs", hidden = true)
    @GetMapping("/")
    public ResponseEntity index() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "https://github.com/khaiyik2612/permissionCS");
        return new ResponseEntity<String>(headers,HttpStatus.PERMANENT_REDIRECT);
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