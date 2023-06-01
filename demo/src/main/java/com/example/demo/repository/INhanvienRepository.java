package com.example.demo.repository;

import com.example.demo.entity.Nhanvien;
import com.example.demo.entity.Nhanvien;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface INhanvienRepository extends JpaRepository<Nhanvien,Long> {

}
