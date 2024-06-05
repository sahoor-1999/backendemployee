package com.hinduja.controller;

import org.springframework.web.bind.annotation.RestController;

import com.hinduja.payload.ModuleDTO;
import com.hinduja.service.ModuleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin("*")
@RestController
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    //URL - http://localhost:8080/module/new/{roleId}
    @PostMapping("/new/{roleId}")
    ResponseEntity<ModuleDTO> createModule(@RequestBody ModuleDTO moduleDTO, @PathVariable(value = "roleId") Long roleId) {
        ModuleDTO c_module = moduleService.createModule(moduleDTO, roleId);
        return new ResponseEntity<>(c_module, HttpStatus.CREATED);
    }

    // URL - http://localhost:8080/module/get
    @GetMapping("/get")
    ResponseEntity<List<ModuleDTO>> getRole(){
        List<ModuleDTO> get_module = moduleService.getAllModules();
        return new ResponseEntity<>(get_module, HttpStatus.OK);
    }

    // URL - http://localhost:8080/module/get/{moduleName}
    @GetMapping("/get/{moduleName}")
    ResponseEntity<List<ModuleDTO>> getRoleByName(@PathVariable(value = "moduleName") String moduleName){
        List<ModuleDTO> l_module = moduleService.getModuleByName(moduleName);
        return new ResponseEntity<>(l_module, HttpStatus.OK);

    }

    //URL - http://localhost:8080/module/update
    @PutMapping("/update")
    ResponseEntity<ModuleDTO> updateModule(@RequestBody ModuleDTO moduleDTO) {
        ModuleDTO c_module = moduleService.updateModule(moduleDTO);
        return new ResponseEntity<>(c_module, HttpStatus.CREATED);
    }
}
