package com.poly.truongnvph29176.controller;

import com.poly.truongnvph29176.dto.PhieuGiamGiaDTO;
import com.poly.truongnvph29176.entity.KhachHang;
import com.poly.truongnvph29176.entity.PhieuGiamGia;
import com.poly.truongnvph29176.service.KhachHangService;
import com.poly.truongnvph29176.service.PhieuGiamGiaService;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/phieu-giam-gia")
public class PhieuGiamGiaController {
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private PhieuGiamGiaService phieuGiamGiaService;
    @Autowired
    private PhieuGiamGiaDTO phieuGiamGiaDTO;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0", name = "page") Integer number) {
        Pageable pageable = PageRequest.of(number, 5);
        List<KhachHang> listKhachHang = khachHangService.getAll();
        Page<PhieuGiamGia> listPhieuGiamGia = phieuGiamGiaService.getALl(pageable);
        model.addAttribute("listKhachHang", listKhachHang);
        model.addAttribute("listPhieuGiamGia", listPhieuGiamGia);
        model.addAttribute("pgg", phieuGiamGiaDTO);
        return "index";
    }

    @GetMapping("/delete/{maPhieu}")
    public String delete(@ModelAttribute("pgg") PhieuGiamGia phieuGiamGia) {
        phieuGiamGiaService.remove(phieuGiamGia.getMaPhieu());
        return "redirect:/phieu-giam-gia/hien-thi";
    }

    @GetMapping("/view-update/{maPhieu}")
    public String viewUpdate(Model model, @PathVariable("maPhieu") String maPhieu) {
        PhieuGiamGia maPhieuGiamGia = phieuGiamGiaService.findByMaPhieu(maPhieu);
        List<KhachHang> listKhachHang = khachHangService.getAll();
        model.addAttribute("listKhachHang", listKhachHang);
        model.addAttribute("pgg", maPhieuGiamGia);
        return "update";
    }

    @PostMapping("/update/{maPhieu}")
    public String update(Model model, @Valid @ModelAttribute("pgg") PhieuGiamGiaDTO phieuGiamGiaDTO, BindingResult result) {
        if(result.hasErrors()) {
            List<KhachHang> listKhachHang = khachHangService.getAll();
            model.addAttribute("listKhachHang", listKhachHang);
            return "update";
        }else {
            phieuGiamGiaService.saveOrUpdate(phieuGiamGiaDTO);
            return "redirect:/phieu-giam-gia/hien-thi";
        }
    }

    @GetMapping("/search")
    public String search(@ModelAttribute("pgg") PhieuGiamGiaDTO phieuGiamGiaDTO,
                         Model model, @RequestParam(defaultValue = "0", name = "page") Integer number) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<PhieuGiamGia> listPhieuGiamGia = phieuGiamGiaService.search(
                phieuGiamGiaDTO.getNgayBatDau(),
                phieuGiamGiaDTO.getNgayKetThuc(),
                phieuGiamGiaDTO.getKhachHang().getMa(),
                pageable
        );
        model.addAttribute("listPhieuGiamGia", listPhieuGiamGia);
        List<KhachHang> listKhachHang = khachHangService.getAll();
        model.addAttribute("listKhachHang", listKhachHang);
        return "index";
    }

}
