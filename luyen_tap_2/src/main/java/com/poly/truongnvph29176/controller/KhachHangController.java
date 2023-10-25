package com.poly.truongnvph29176.controller;

import com.poly.truongnvph29176.dto.KhachHangDTO;
import com.poly.truongnvph29176.entity.HangKhachHang;
import com.poly.truongnvph29176.entity.KhachHang;
import com.poly.truongnvph29176.service.HangKhachHangService;
import com.poly.truongnvph29176.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired
    private HangKhachHangService hangKhachHangService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private KhachHangDTO khachHangDTO;


    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number) {
        List<HangKhachHang> listHangKhachHang = hangKhachHangService.getAll();
        Pageable pageable = PageRequest.of(number, 5);
        Page<KhachHang> listKhachHang = khachHangService.getAll(pageable);
        model.addAttribute("listHangKhachHang", listHangKhachHang);
        model.addAttribute("listKhachHang", listKhachHang);
        model.addAttribute("kh", khachHangDTO);
        return "index";
    }

    @GetMapping("/delete/{maKhachHang}")
    public String delete(@ModelAttribute("kh") KhachHang khachHang) {
        khachHangService.delete(khachHang.getMaKhachHang());
        return "redirect:/khach-hang/hien-thi";
    }

    @PostMapping("/add")
    public String add(Model model, @Valid @ModelAttribute("kh") KhachHangDTO khachHangDTO,
                      BindingResult result,
                      @RequestParam(defaultValue = "0", name = "page") Integer number) {
        if(result.hasErrors()) {
            List<HangKhachHang> listHangKhachHang = hangKhachHangService.getAll();
            Pageable pageable = PageRequest.of(number, 5);
            Page<KhachHang> listKhachHang = khachHangService.getAll(pageable);
            model.addAttribute("listHangKhachHang", listHangKhachHang);
            model.addAttribute("listKhachHang", listKhachHang);
            return "index";
        }else {
            khachHangService.add(khachHangDTO);
            return "redirect:/khach-hang/hien-thi";
        }
    }

    @GetMapping("/search")
    public String search(Model model, @ModelAttribute("kh") KhachHangDTO khachHangDTO,
                         @RequestParam(defaultValue = "0", name = "page") Integer number) {
        List<HangKhachHang> listHangKhachHang = hangKhachHangService.getAll();
        model.addAttribute("listHangKhachHang", listHangKhachHang);
        Pageable pageable = PageRequest.of(number, 5);
        Page<KhachHang> listKhachHang = khachHangService.search(
                khachHangDTO.getTenKhachHang(),
                khachHangDTO.getHangKhachHang().getMaHang(),
                pageable);
        model.addAttribute("listKhachHang", listKhachHang);
        return "index";
    }
}
