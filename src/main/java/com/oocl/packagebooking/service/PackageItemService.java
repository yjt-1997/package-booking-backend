package com.oocl.packagebooking.service;

import com.oocl.packagebooking.Entity.PackageItem;
import com.oocl.packagebooking.dao.PackageItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageItemService {

    @Autowired
    private PackageItemRepository packageItemRepository;

    public PackageItem save(PackageItem packageItem) {
        return packageItemRepository.save(packageItem);
    }

    public List<PackageItem> findAll() {
        return packageItemRepository.findAll();
    }
}
