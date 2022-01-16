package com.khaiyik.casestudy.permission.controllers;

import com.khaiyik.casestudy.permission.model.permissions;
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
@Api(tags = "Permissions Switcher Commands", value = "Permissions Switcher Commands", description = "Controller for Permissions Commands")
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
    public Map<String, Object> checkPermissions(@RequestParam(name="email") String email,@RequestParam(name="featureName") String permName) {
        permissions searchObj = new permissions();
        searchObj.setFeatureName(permName);
        searchObj.setEmail(email);
        return permissionService.checkPermissions(searchObj);
    }

    @GetMapping("/permissions")
    public List<permissions> getPermissions() {
            return permissionService.getAllPermissions();
    }

    @PostMapping("/feature")
    public ResponseEntity<Object> modPermissions(@RequestBody permissions params) {

        if (permissionService.addPermissions(params))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}