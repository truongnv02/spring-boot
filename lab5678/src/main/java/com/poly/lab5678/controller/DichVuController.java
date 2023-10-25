package com.poly.lab5678.controller;

import com.poly.lab5678.entity.DichVu;
import com.poly.lab5678.entity.LoaiDichVu;
import com.poly.lab5678.service.DichVuService;
import com.poly.lab5678.service.LoaiDichVuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/dich-vu")
public class DichVuController {
    @Autowired
    private DichVuService dichVuService;
    @Autowired
    private LoaiDichVuService loaiDichVuService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number) {
        Pageable pageable = PageRequest.of(number, 4);
        List<DichVu> listDichVu = dichVuService.getAll();
        List<LoaiDichVu> listLoaiDichVu = loaiDichVuService.getAl();
        model.addAttribute("listDichVu", listDichVu);
        model.addAttribute("listLoaiDichVu", listLoaiDichVu);
        model.addAttribute("dv", new DichVu());
        return "index";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("dv") DichVu dichVu, BindingResult result) {
        if(result.hasErrors()) {
            return "index";
        }else {
            dichVu.setMa(dichVuService.generateMaDichVu());
            dichVuService.save(dichVu);
            return "redirect:/dich-vu/hien-thi";
        }
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id) {
        DichVu idDichVu = dichVuService.findById(id);
        List<LoaiDichVu> listLoaiDichVu = loaiDichVuService.getAl();
        model.addAttribute("listLoaiDichVu", listLoaiDichVu);
        model.addAttribute("dv", idDichVu);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("dv") DichVu dichVu, BindingResult result) {
        if(result.hasErrors()) {
            return "index";
        }else {
            dichVuService.update(dichVu);
            return "redirect:/dich-vu/hien-thi";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")UUID id) {
        dichVuService.delete(id);
        return "redirect:/dich-vu/hien-thi";
    }

    @GetMapping("/search")
    public String search(Model model, @ModelAttribute("dv") DichVu dichVu) {
        List<DichVu> listDichVu = dichVuService.findDichVuByNameAndLoaiDichVu(dichVu.getTen(), dichVu.getLoaiDichVu().getId());
        List<LoaiDichVu> listLoaiDichVu = loaiDichVuService.getAl();
        model.addAttribute("listLoaiDichVu", listLoaiDichVu);
        model.addAttribute("listDichVu", listDichVu);
        return "index";
    }

    @GetMapping("/searchDate")
    public String searchDate(Model model, @ModelAttribute("dv") DichVu dichVu) {
        List<DichVu> listDichVu = dichVuService.findByNgayTaoBetween(dichVu.getNgayTao());
        model.addAttribute("listDichVu", listDichVu);
        List<LoaiDichVu> listLoaiDichVu = loaiDichVuService.getAl();
        model.addAttribute("listLoaiDichVu", listLoaiDichVu);
        return "index";
    }

}
