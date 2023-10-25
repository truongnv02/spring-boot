package com.poly.lab5678.service;

import com.poly.lab5678.entity.LoaiDichVu;

import java.util.List;
import java.util.UUID;

public interface LoaiDichVuService {
    List<LoaiDichVu> getAl();
    LoaiDichVu findById(UUID id);
}
