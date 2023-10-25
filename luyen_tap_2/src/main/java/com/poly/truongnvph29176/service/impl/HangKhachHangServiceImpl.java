package com.poly.truongnvph29176.service.impl;

import com.poly.truongnvph29176.entity.HangKhachHang;
import com.poly.truongnvph29176.repository.HangKhachHangRepository;
import com.poly.truongnvph29176.service.HangKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangKhachHangServiceImpl implements HangKhachHangService {
    @Autowired
    private HangKhachHangRepository hangKhachHangRepository;

    @Override
    public List<HangKhachHang> getAll() {
        return hangKhachHangRepository.findAll();
    }
}
