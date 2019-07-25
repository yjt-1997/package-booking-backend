create table `package_item`(
    `id` int auto_increment primary key,
    `receiver_name` varchar(255),
    `receiver_phone` varchar(255),
    `status` varchar(255),
    `order_time` TIMESTAMP
);