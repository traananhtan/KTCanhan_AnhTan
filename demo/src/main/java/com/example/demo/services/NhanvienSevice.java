package com.example.demo.services;

import com.example.demo.entity.Nhanvien;
import com.example.demo.repository.INhanvienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanvienSevice {
    @Autowired
    private INhanvienRepository nhanvienRepository;
    public List<Nhanvien> getAllnhanvien(){
        return nhanvienRepository.findAll();
    }
    public Nhanvien getnhanvienById(Long id){
        return nhanvienRepository.findById(id).orElse(null);
    }
    public void add(Nhanvien nhanvien){
        nhanvienRepository.save(nhanvien);
    }
    public void delete(Long id){
        nhanvienRepository.deleteById(id);
    }
    public void update(Nhanvien nhanvien){
        nhanvienRepository.save(nhanvien);
    }

//    public List<Nhanvien> getAllNhanviens() {
//        return null;
//    }
//
//    public void addNhanvien(Nhanvien nhanvien) {
//    }
//
//    public void deleteNhanvien(Long id) {
//    }
//
//    public Nhanvien getNhanvienId(Long id) {
//        return null;
//    }
//
//    public void updateNhanvien(Nhanvien existingNhanvien) {
//    }
}
