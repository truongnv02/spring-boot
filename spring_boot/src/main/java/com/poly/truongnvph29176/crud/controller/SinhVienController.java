package com.poly.truongnvph29176.crud.controller;

import com.poly.truongnvph29176.crud.model.SinhVien;
import com.poly.truongnvph29176.crud.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute SinhVien sinhVien) {
        service.addSinhVien(sinhVien);
        return "redirect:/sinh-vien/hien-thi";
    }

    @GetMapping("/detail/{mssv}")
    public String detail(@PathVariable("mssv") String ma, Model model) {
        SinhVien sinhVien = service.detailSinhVien(ma);
        model.addAttribute("sv", sinhVien);
        return "detail";
    }

    @GetMapping("/remove/{mssv}")
    public String remove(@PathVariable("mssv") String ma) {
        service.deleteSinhVien(ma);
        System.out.println("Da xoa sinh vien ma: " + ma);
        return "redirect:/sinh-vien/hien-thi";
    }

    @PostMapping("/update/{mssv}")
    public String update(@PathVariable("mssv") String ma, @ModelAttribute("sv") SinhVien sinhVien) {
        service.updateSinhVien(ma, sinhVien);
        return "redirect:/sinh-vien/hien-thi";
    }
}
