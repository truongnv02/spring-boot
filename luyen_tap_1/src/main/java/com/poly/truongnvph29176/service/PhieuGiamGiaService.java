package com.poly.truongnvph29176.service;

import com.poly.truongnvph29176.dto.PhieuGiamGiaDTO;
import com.poly.truongnvph29176.entity.PhieuGiamGia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface PhieuGiamGiaService {
    Page<PhieuGiamGia> getALl(Pageable pageable);
    PhieuGiamGia saveOrUpdate(PhieuGiamGiaDTO phieuGiamGiaDTO);
    PhieuGiamGia findByMaPhieu(String maPhieu);
    Page<PhieuGiamGia> search(Date startDate, Date endDate, Long ma, Pageable pageable);
    void remove(String id);
    String maTuDong();
}
