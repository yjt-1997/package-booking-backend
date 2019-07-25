package com.oocl.packagebooking.controller;


import com.oocl.packagebooking.Entity.PackageItem;
import com.oocl.packagebooking.service.PackageItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PackageItemController {

    @Autowired
    private PackageItemService packageItemService;

    @PostMapping("/items")
    public ResponseEntity<PackageItem> save(PackageItem packageItem){
        return ResponseEntity.status(HttpStatus.CREATED).body(packageItemService.save(packageItem));
    }

    @GetMapping("/items")
    public ResponseEntity<List<PackageItem>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(packageItemService.findAll());
    }

    @GetMapping("/items/{status}")
    public ResponseEntity<List<PackageItem>> findByStatus(@PathVariable String status){
        return ResponseEntity.status(HttpStatus.OK).body(packageItemService.findByStatus(status));
    }
}
