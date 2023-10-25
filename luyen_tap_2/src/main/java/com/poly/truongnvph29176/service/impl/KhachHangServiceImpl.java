package com.poly.truongnvph29176.service.impl;

import com.poly.truongnvph29176.dto.KhachHangDTO;
import com.poly.truongnvph29176.entity.KhachHang;
import com.poly.truongnvph29176.repository.KhachHangRepository;
import com.poly.truongnvph29176.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public Page<KhachHang> getAll(Pageable pageable) {
        return khachHangRepository.findAll(pageable);
    }

    @Override
    public KhachHang add(KhachHangDTO khachHangDTO) {
        KhachHang kh = new KhachHang();
        kh.setTenKhachHang(khachHangDTO.getTenKhachHang());
        kh.setSdt(khachHangDTO.getSdt());
        kh.setGioiTinh(khachHangDTO.getGioiTinh());
        kh.setHangKhachHang(khachHangDTO.getHangKhachHang());
        return khachHangRepository.save(kh);
    }

    @Override
    public void delete(Long maKhachHang) {
        khachHangRepository.deleteById(maKhachHang);
    }

    @Override
    public Page<KhachHang> search(String ten, Integer maHang, Pageable pageable) {
        return khachHangRepository.search(ten, maHang, pageable);
    }
}
