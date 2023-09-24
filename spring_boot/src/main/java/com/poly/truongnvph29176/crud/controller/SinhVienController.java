package com.poly.truongnvph29176.crud.controller;

import com.poly.truongnvph29176.crud.model.SinhVien;
import com.poly.truongnvph29176.crud.service.SinhVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sinh-vien")
public class SinhVienController {
    @Autowired
    private SinhVienService service;

    private List<SinhVien> listSinhVien = new ArrayList<>();

    @GetMapping("/hien-thi")
    public String hienThiDanhSachSinhVien(Model model) {
        listSinhVien = service.getAll();
        model.addAttribute("listSinhVien", listSinhVien);
        model.addAttribute("sv", new SinhVien());
        return "sinh_vien/index";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("sv") SinhVien sinhVien, BindingResult result) {
        if(result.hasErrors()) {
            return "sinh_vien/index";
        }else {
            service.addSinhVien(sinhVien);
            return "redirect:/sinh-vien/hien-thi";
        }
    }

    @GetMapping("/detail/{mssv}")
    public String detail(@PathVariable("mssv") String ma, Model model) {
        SinhVien sinhVien = service.detailSinhVien(ma);
        model.addAttribute("sv", sinhVien);
        return "sinh_vien/detail";
    }

    @GetMapping("/remove/{mssv}")
    public String remove(@PathVariable("mssv") String ma) {
        service.deleteSinhVien(ma);
        System.out.println("Da xoa sinh vien ma: " + ma);
        return "redirect:/sinh-vien/hien-thi";
    }

    @PostMapping("/update/{mssv}")
    public String update(@Valid @ModelAttribute("sv") SinhVien sinhVien, BindingResult result) {
        if(result.hasErrors()) {
            return "sinh_vien/detail";
        }else {
            service.updateSinhVien(sinhVien);
            return "redirect:/sinh-vien/hien-thi";
        }
    }

    @PostMapping("/search")
    public String search(Model model, @ModelAttribute("sv") SinhVien sinhVien) {
        SinhVien sv = service.search(sinhVien.getTen());
        model.addAttribute("sv", sv);
        listSinhVien = service.getAll();
        model.addAttribute("listSinhVien", listSinhVien);
        return "sinh_vien/index";
    }

}
