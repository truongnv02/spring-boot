package com.poly.lab5678.service;

import com.poly.lab5678.entity.DichVu;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface DichVuService {
    List<DichVu> getAll();
    DichVu save(DichVu dichVu);
    DichVu update(DichVu dichVu);
    String generateMaDichVu();
    DichVu findById(UUID id);
    List<DichVu> findByName(String ten);
    List<DichVu> findByNgayTaoBetween(Date startDate);
    List<DichVu> findDichVuByNameAndLoaiDichVu(String ten, UUID id);
    void delete(UUID id);
}
