package com.poly.truongnvph29176.crud_jpa.service;

import com.poly.truongnvph29176.crud_jpa.entity.CuaHang;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {
    List<CuaHang> getAll();

    void deleteById(UUID id);

    CuaHang saveOrUpdate(CuaHang cuaHang);
}
