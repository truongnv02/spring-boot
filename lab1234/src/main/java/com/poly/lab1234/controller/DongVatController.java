package com.poly.lab1234.controller;

import com.poly.lab1234.model.DongVat;
import com.poly.lab1234.service.DongVatService;
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

import java.util.List;

@Controller
@RequestMapping("/dong-vat")
public class DongVatController {
    @Autowired
    private DongVatService dongVatService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("dv", new DongVat());
        return "dong_vat/index";
    }

    @GetMapping("/hien-thi-tat-ca")
    public String hienThi(Model model) {
        List<DongVat> listDongVat = dongVatService.getAll();
        model.addAttribute("listDongVat", listDongVat);
        model.addAttribute("dv", new DongVat());
        return "dong_vat/index";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("dv") DongVat dongVat, BindingResult result) {
        if(result.hasErrors()) {
            return "dong_vat/index";
        }else {
            dongVatService.add(dongVat);
            return "redirect:/dong-vat/hien-thi-tat-ca";
        }
    }

    @GetMapping("/view-update/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        DongVat dv = dongVatService.detail(id);
        model.addAttribute("dv", dv);
        return "dong_vat/detail";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("dv") DongVat dongVat, BindingResult result) {
        if(result.hasErrors()) {
            return "dong_vat/detail";
        }else {
            dongVatService.update(dongVat);
            return "redirect:/dong-vat/hien-thi-tat-ca";
        }
    }

    @PostMapping("/search")
    public String search(Model model, @ModelAttribute("dv") DongVat dongVat) {
        DongVat dv = dongVatService.search(dongVat.getTen());
        model.addAttribute("dv", dv);
        return "dong_vat/index";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        dongVatService.delete(id);
        return "redirect:/dong-vat/hien-thi-tat-ca";
    }
}
