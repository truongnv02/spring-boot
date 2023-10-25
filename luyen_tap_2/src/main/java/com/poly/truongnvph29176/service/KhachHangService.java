package com.poly.truongnvph29176.service;

import com.poly.truongnvph29176.dto.KhachHangDTO;
import com.poly.truongnvph29176.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KhachHangService {
    Page<KhachHang> getAll(Pageable pageable);
    KhachHang add(KhachHangDTO khachHangDTO);
    void delete(Long maKhachHang);
    Page<KhachHang> search(String ten, Integer maHang, Pageable pageable);
}
