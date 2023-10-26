package com.poly.truongnvph29176.controller;

import com.poly.truongnvph29176.dto.DanhSachYeuThichDTO;
import com.poly.truongnvph29176.entity.DanhSachYeuThich;
import com.poly.truongnvph29176.entity.KhachHang;
import com.poly.truongnvph29176.service.DanhSachYeuThichService;
import com.poly.truongnvph29176.service.KhachHangService;
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
@RequestMapping("/danh-sach-yeu-thich")
public class DanhSachYeuThichController {
    @Autowired
    private DanhSachYeuThichService danhSachYeuThichService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private DanhSachYeuThichDTO danhSachYeuThichDTO;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<DanhSachYeuThich> listDanhSachYeuThich = danhSachYeuThichService.getAll(pageable);
        model.addAttribute("listDanhSachYeuThich", listDanhSachYeuThich);
        return "index";
    }

    @GetMapping("/delete/{ma}")
    public String delete(@ModelAttribute("dsyt") DanhSachYeuThich danhSachYeuThich) {
        danhSachYeuThichService.delete(danhSachYeuThich.getMa());
        return "redirect:/danh-sach-yeu-thich/hien-thi";
    }

    @GetMapping("/sort")
    public String sort(Model model, @ModelAttribute("dsyt") DanhSachYeuThich danhSachYeuThich,
                       @RequestParam(defaultValue = "0", name = "page") Integer number) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<DanhSachYeuThich> listDanhSachYeuThich = danhSachYeuThichService.sort(pageable);
        model.addAttribute("listDanhSachYeuThich", listDanhSachYeuThich);
        return "index";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        List<KhachHang> listKhachHang = khachHangService.getAll();
        model.addAttribute("listKhachHang", listKhachHang);
        model.addAttribute("dsyt", danhSachYeuThichDTO);
        return "add";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("dsyt") DanhSachYeuThichDTO danhSachYeuThichDTO,
                      BindingResult result) {
        if(result.hasErrors()) {
            List<KhachHang> listKhachHang = khachHangService.getAll();
            model.addAttribute("listKhachHang", listKhachHang);
            return "add";
        }else {
            danhSachYeuThichService.add(danhSachYeuThichDTO);
            return "redirect:/danh-sach-yeu-thich/hien-thi";
        }
    }
}
