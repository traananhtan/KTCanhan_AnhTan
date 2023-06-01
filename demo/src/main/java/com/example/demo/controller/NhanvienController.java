package com.example.demo.controller;

import com.example.demo.entity.Nhanvien;
import com.example.demo.entity.Nhanvien;
import com.example.demo.services.NhanvienSevice;
import com.example.demo.services.PhongBanService;
import com.example.demo.services.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/Nhanvien")
public class NhanvienController {
    @Autowired
    private NhanvienSevice nhanvienService;
    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String showAllNhanvien(Model model) {
        List<Nhanvien> nhanvien = nhanvienService.getAllnhanvien();
        model.addAttribute("Nhanvien", nhanvien);
        return "Nhanvien/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("searchText") String searchText, Model model) {
        List<Nhanvien> nhanviens = nhanvienService.getAllnhanvien();
        List<Nhanvien> filteredNhanviens = new ArrayList<>();

        if (searchText != null && !searchText.isEmpty()) {
            filteredNhanviens = nhanviens.stream()
                    .filter(nhanvien -> nhanvien.getTenNv().contains(searchText))
                    .collect(Collectors.toList());
        }

        model.addAttribute("Nhanvien", filteredNhanviens);
        return "Nhanvien/list";
    }

    @GetMapping("/add")
    public String addNhanvienForm(Model model) {
        model.addAttribute("nhanvien", new Nhanvien());
        model.addAttribute("phongban", phongBanService.getAllPhongBan());
        return "Nhanvien/add";
    }

    @PostMapping("/add")
    public String addNhanvien(@Valid @ModelAttribute("nhanvien") Nhanvien nhanvien, @RequestParam("imageProduct") MultipartFile imageProduct, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", phongBanService.getAllPhongBan());
            return "Nhanvien/add";
        } else {
            if (imageProduct != null && imageProduct.getSize() > 0) {
                try {
                    String newImageFile = UUID.randomUUID() + ".png";
                    Path path = Paths.get("images/" + newImageFile);
                    Files.copy(imageProduct.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                    nhanvien.setImage(newImageFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            nhanvienService.add(nhanvien);
            return "redirect:/Nhanvien";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteNhanvien(@PathVariable("id") Long id) {
        nhanvienService.delete(id);
        return "redirect:/Nhanvien";
    }

    @GetMapping("/edit/{id}")
    public String editNhanvienForm(@PathVariable("id") Long id, Model model) {
        Nhanvien editNhanvien = nhanvienService.getnhanvienById(id);
        if (editNhanvien != null) {
            model.addAttribute("nhanvien", editNhanvien);
            model.addAttribute("categories", phongBanService.getAllPhongBan());
            return "Nhanvien/edit";
        } else {
            return "redirect:/Nhanvien";
        }
    }

    @PostMapping("/edit/{id}")
    public String editNhanvien(@PathVariable("id") Long id, @ModelAttribute("nhanvien") Nhanvien editNhanvien, @RequestParam MultipartFile imageProduct, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", phongBanService.getAllPhongBan());
            return "Nhanvien/edit";
        }
        if (imageProduct != null && imageProduct.getSize() > 0) {
            try {
                Path path = Paths.get("images/" + editNhanvien.getImage());
                Files.copy(imageProduct.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Nhanvien existingNhanvien = nhanvienService.getnhanvienById(id);
            if (existingNhanvien != null) {
                existingNhanvien.setMaNv(editNhanvien.getMaNv());
                existingNhanvien.setTenNv(editNhanvien.getTenNv());
                existingNhanvien.setPhai(editNhanvien.getPhai());
                existingNhanvien.setNoisinh(editNhanvien.getNoisinh());
                existingNhanvien.setMaPhong(editNhanvien.getMaPhong());
                existingNhanvien.setImage(editNhanvien.getImage());
                existingNhanvien.setPhongban(editNhanvien.getPhongban());
                nhanvienService.update(existingNhanvien);
            }
            return "redirect:/Nhanvien";
        }
        return "redirect:/Nhanvien";
    }
}





