package com.poly.truongnvph29176.service.impl;

import com.poly.truongnvph29176.dto.DanhSachYeuThichDTO;
import com.poly.truongnvph29176.entity.DanhSachYeuThich;
import com.poly.truongnvph29176.repository.DanhSachYeuThichRepository;
import com.poly.truongnvph29176.service.DanhSachYeuThichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DanhSachYeuThichServieImpl implements DanhSachYeuThichService {
    @Autowired
    private DanhSachYeuThichRepository danhSachYeuThichRepository;

    @Override
    public Page<DanhSachYeuThich> getAll(Pageable pageable) {
        return danhSachYeuThichRepository.findAll(pageable);
    }

    @Override
    public DanhSachYeuThich add(DanhSachYeuThichDTO danhSachYeuThichDTO) {
        DanhSachYeuThich danhSachYeuThich = new DanhSachYeuThich();
        danhSachYeuThich.setGhiChu(danhSachYeuThichDTO.getGhiChu());
        danhSachYeuThich.setTrangThai(danhSachYeuThichDTO.getTrangThai());
        danhSachYeuThich.setKhachHang(danhSachYeuThichDTO.getKhachHang());
        return danhSachYeuThichRepository.save(danhSachYeuThich);
    }

    @Override
    public void delete(UUID ma) {
        danhSachYeuThichRepository.deleteById(ma);
    }

    @Override
    public Page<DanhSachYeuThich> sort(Pageable pageable) {
        return danhSachYeuThichRepository.sort(pageable);
    }
}
