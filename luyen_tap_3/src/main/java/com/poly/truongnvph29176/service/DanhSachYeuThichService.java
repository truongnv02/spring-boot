package com.poly.truongnvph29176.service;

import com.poly.truongnvph29176.dto.DanhSachYeuThichDTO;
import com.poly.truongnvph29176.entity.DanhSachYeuThich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface DanhSachYeuThichService {
    Page<DanhSachYeuThich> getAll(Pageable pageable);
    DanhSachYeuThich add(DanhSachYeuThichDTO danhSachYeuThichDTO);
    void delete(UUID ma);
    Page<DanhSachYeuThich> sort(Pageable pageable);
}
