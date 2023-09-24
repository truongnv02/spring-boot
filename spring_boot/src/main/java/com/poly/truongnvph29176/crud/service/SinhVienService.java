package com.poly.truongnvph29176.crud.service;

import com.poly.truongnvph29176.crud.model.SinhVien;

import java.util.List;

public interface SinhVienService {
    List<SinhVien> getAll();

    void addSinhVien(SinhVien sinhVien);

    SinhVien detailSinhVien(String ma);

    SinhVien search(String ten);

    void deleteSinhVien(String ma);

    void updateSinhVien(SinhVien sinhVien);
}
