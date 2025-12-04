-- MySQL schema for tb_staff
CREATE DATABASE IF NOT EXISTS server_api;
USE server_api;

CREATE TABLE IF NOT EXISTS tb_staff (
  staff_id INT AUTO_INCREMENT PRIMARY KEY,
  staff_name VARCHAR(255) NOT NULL,
  staff_hp VARCHAR(50) DEFAULT NULL,
  staff_alamat TEXT DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
