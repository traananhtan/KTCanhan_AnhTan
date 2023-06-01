package com.example.demo.services;

import com.example.demo.entity.Phongban;
import com.example.demo.repository.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {
    @Autowired
    private IPhongBanRepository phongBanRepository;
    private Phongban PhongBan;

    public List<Phongban> getAllPhongBan(){
        return phongBanRepository.findAll();
    }
    public Phongban getPhongBanById(Long id){
        return phongBanRepository.findById(id).orElse(null);
    }
    public Phongban savePhongBan(Phongban phongBan){
        return phongBanRepository.save(PhongBan);
    }
    public void deleteCategory(Long id){phongBanRepository.deleteById(id);
    }
}
