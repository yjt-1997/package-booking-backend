package com.oocl.packagebooking.controller;


import com.oocl.packagebooking.Entity.PackageItem;
import com.oocl.packagebooking.service.PackageItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PackageItemController {

    @Autowired
    private PackageItemService packageItemService;

    @PostMapping("/items")
    public ResponseEntity<PackageItem> save(PackageItem packageItem){
        return ResponseEntity.status(HttpStatus.CREATED).body(packageItemService.save(packageItem));
    }
}
