package com.oocl.packagebooking.service;

import com.oocl.packagebooking.constrant.PackageStatus;
import com.oocl.packagebooking.entity.PackageItem;
import com.oocl.packagebooking.dao.PackageItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<PackageItem> findByStatus(String status) {
        return packageItemRepository.findAll().stream().filter(
                packageItem -> packageItem.getStatus().equals(status)).collect(Collectors.toList());
    }

    public PackageItem orderItem(int id, PackageItem packageItem)throws Exception{
        PackageItem origin  = packageItemRepository.findById(id).get();
        if(origin==null){
            throw new Exception();
        }
        long timeLong = packageItem.getOrderTime();
        String timeString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(packageItem.getOrderTime()).toString();
        int hour = Integer.parseInt(timeString.split(" ")[1].trim().split(":")[0]);
        if(hour<9||hour>21){
            throw  new Exception();
        }
        origin.setOrderTime(timeLong);
        origin.setStatus(PackageStatus.IS_ORDERED);
        packageItemRepository.save(origin);
        return origin;
    }
}
