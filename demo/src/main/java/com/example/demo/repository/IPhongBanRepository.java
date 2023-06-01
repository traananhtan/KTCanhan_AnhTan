package com.example.demo.repository;

import com.example.demo.entity.Phongban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhongBanRepository extends JpaRepository<Phongban,Long> {
}
