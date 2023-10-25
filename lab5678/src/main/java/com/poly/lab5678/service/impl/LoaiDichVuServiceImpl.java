package com.poly.lab5678.service.impl;

import com.poly.lab5678.entity.LoaiDichVu;
import com.poly.lab5678.repository.LoaiDichVuRepository;
import com.poly.lab5678.service.LoaiDichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoaiDichVuServiceImpl implements LoaiDichVuService {
    @Autowired
    private LoaiDichVuRepository loaiDichVuRepository;

    @Override
    public List<LoaiDichVu> getAl() {
        return loaiDichVuRepository.findAll();
    }

    @Override
    public LoaiDichVu findById(UUID id) {
        return loaiDichVuRepository.findById(id).orElse(null);
    }
}
