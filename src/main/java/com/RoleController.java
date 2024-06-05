package com.hinduja.controller;

import org.springframework.web.bind.annotation.RestController;

import com.hinduja.payload.RoleDTO;
import com.hinduja.service.RoleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin("*")
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    // URL - http://localhost:8080/role/new
    @PostMapping("/new")
    ResponseEntity<RoleDTO> createRole(@Validated @RequestBody RoleDTO roleDTO){
        RoleDTO c_Role = roleService.createRole(roleDTO);
        return new ResponseEntity<>(c_Role, HttpStatus.CREATED);
    }

    // URL - http://localhost:8080/role/get
    @GetMapping("/get")
    ResponseEntity<List<RoleDTO>> getRole(){
        List<RoleDTO> g_role = roleService.getAllRoles();
        return new ResponseEntity<>(g_role, HttpStatus.OK);
    }
}
