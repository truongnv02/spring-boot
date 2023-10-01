package com.poly.truongnvph29176.crud_jpa.controller;

import com.poly.truongnvph29176.crud_jpa.entity.CuaHang;
import com.poly.truongnvph29176.crud_jpa.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cua-hang")
public class CuaHangController {
    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("/index")
    public String index(Model model) {
        List<CuaHang> listCuaHang = cuaHangService.getAll();
        model.addAttribute("listCuaHang", listCuaHang);
        model.addAttribute("ch", new CuaHang());
        return "cua_hang/index";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("ch") CuaHang cuaHang) {
        return "cua_hang/index";
    }
}
