package com.poly.truongnvph29176.service.impl;

import com.poly.truongnvph29176.entity.KhachHang;
import com.poly.truongnvph29176.repository.KhachHangRepository;
import com.poly.truongnvph29176.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.findAll();
    }
}
