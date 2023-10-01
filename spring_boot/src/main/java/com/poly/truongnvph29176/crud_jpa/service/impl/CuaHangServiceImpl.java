package com.poly.truongnvph29176.crud_jpa.service.impl;

import com.poly.truongnvph29176.crud_jpa.entity.CuaHang;
import com.poly.truongnvph29176.crud_jpa.repository.CuaHangRepository;
import com.poly.truongnvph29176.crud_jpa.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CuaHangServiceImpl implements CuaHangService {
    @Autowired
    private CuaHangRepository cuaHangRepository;

    @Override
    public List<CuaHang> getAll() {
        List<CuaHang> listCuaHang = cuaHangRepository.findAll();
        return listCuaHang;
    }

    @Override
    public void deleteById(UUID id) {
        cuaHangRepository.deleteById(id);
    }

    @Override
    public CuaHang saveOrUpdate(CuaHang cuaHang) {
        if(cuaHang.getId() == null) {
            return cuaHangRepository.save(cuaHang);
        }else {
            cuaHang.setMa(cuaHang.getMa());
            cuaHang.setTen(cuaHang.getTen());
            cuaHang.setDiaChi(cuaHang.getDiaChi());
            cuaHang.setThanhPho(cuaHang.getThanhPho());
            cuaHang.setQuocGia(cuaHang.getQuocGia());
            return cuaHangRepository.save(cuaHang);
        }
    }
}
