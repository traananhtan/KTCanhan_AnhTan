package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "phongban")
public class Phongban {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maphong;

    @Column(name = "name")
    private String tenphong;

    @OneToMany(mappedBy = "phongban", cascade = CascadeType.ALL)
    private List<Nhanvien> Nhanvien;
}

