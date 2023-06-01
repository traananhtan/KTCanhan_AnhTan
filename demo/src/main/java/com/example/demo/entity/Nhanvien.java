package com.example.demo.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "nhanvien")
public class Nhanvien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MaNv;

    @Column(name = "TenNv")
    @NotEmpty(message = "TenNv must not be empty")
    @Size(max = 50, min = 1, message = "TenNv must be less than 50 characters")
    private String TenNv;

    @Column(name = "Phai")
    private String Phai;

    @Column(name = "noi sinh")
    private String noisinh;

    @Column(name = "Ma Phong")
    private String MaPhong;

    @Column(name = "Luong")
    @NotNull(message = "Luong is required")
    private Double Luong;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "PhongBan_id")

    private Phongban phongban;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")

    private User user;
}
