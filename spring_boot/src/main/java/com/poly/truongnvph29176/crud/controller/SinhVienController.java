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

    @GetMapping("/detail/{masv}")
    public String detail(@PathVariable("masv") String ma, Model model) {
        SinhVien sinhVien = service.detailSinhVien(ma);
        model.addAttribute("sv", sinhVien);
        return "detail";
    }
}
