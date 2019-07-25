package com.oocl.packagebooking.Entity;

import com.oocl.packagebooking.constrant.PackageStatus;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "package_item")
public class PackageItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "receiver_phone")
    private String receiverPhone;

    @Column(name = "status")
    private String status;

    @Column(name = "order_time")
    private Timestamp orderTime;


}
