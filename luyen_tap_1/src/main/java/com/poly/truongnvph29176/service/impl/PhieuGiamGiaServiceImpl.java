package com.poly.truongnvph29176.service.impl;

import com.poly.truongnvph29176.dto.PhieuGiamGiaDTO;
import com.poly.truongnvph29176.entity.PhieuGiamGia;
import com.poly.truongnvph29176.repository.PhieuGiamGiaRepository;
import com.poly.truongnvph29176.service.PhieuGiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Locale;
import java.util.Random;

@Service
public class PhieuGiamGiaServiceImpl implements PhieuGiamGiaService {
    @Autowired
    private PhieuGiamGiaRepository phieuGiamGiaRepository;

    @Override
    public Page<PhieuGiamGia> getALl(Pageable pageable) {
        return phieuGiamGiaRepository.findAll(pageable);
    }

    @Override
    public PhieuGiamGia saveOrUpdate(PhieuGiamGiaDTO phieuGiamGiaDTO) {
        if (!phieuGiamGiaDTO.isNgayKetThucAfterNgayBatDau()) {
            throw new IllegalArgumentException("Ngày kết thúc phải sau ngày bắt đầu");
        }
        PhieuGiamGia phieuGiamGia = new PhieuGiamGia();
        phieuGiamGia.setMaPhieu(phieuGiamGiaDTO.getMaPhieu());
        phieuGiamGia.setTenPhieu(phieuGiamGiaDTO.getTenPhieu());
        phieuGiamGia.setNgayBatDau(phieuGiamGiaDTO.getNgayBatDau());
        phieuGiamGia.setNgayKetThuc(phieuGiamGiaDTO.getNgayKetThuc());
        phieuGiamGia.setGiaTriGiam(phieuGiamGiaDTO.getGiaTriGiam());
        phieuGiamGia.setGiaTriGiamToiDa(phieuGiamGiaDTO.getGiaTriGiamToiDa());
        phieuGiamGia.setTrangThai(phieuGiamGiaDTO.getTrangThai());
        phieuGiamGia.setKhachHang(phieuGiamGiaDTO.getKhachHang());
        return phieuGiamGiaRepository.save(phieuGiamGia);
    }

    @Override
    public PhieuGiamGia findByMaPhieu(String maPhieu) {
        return phieuGiamGiaRepository.findById(maPhieu).orElse(null);
    }

    @Override
    public Page<PhieuGiamGia> search(Date startDate, Date endDate, Long ma, Pageable pageable) {
        return phieuGiamGiaRepository.search(startDate, endDate, ma, pageable);
    }

    @Override
    public void remove(String id) {
        phieuGiamGiaRepository.deleteById(id);
    }

    @Override
    public String maTuDong() {
        String chuThuong = "qwertyuiopasdfghjklzxcvbnm";
        String chuHoa = chuThuong.toUpperCase();
        String so = "1234567890";
        String kiTu = "~!@#$%^&*";
        Random random = new Random();
        StringBuilder maPhieuGiamGia = new StringBuilder();
        for (int  i = 0; i < 4; i++) {
            maPhieuGiamGia.append(chuThuong.charAt(random.nextInt(chuThuong.length())));
        }
        for (int  i = 0; i < 3; i++) {
            maPhieuGiamGia.append(chuHoa.charAt(random.nextInt(chuHoa.length())));
        }
        for (int  i = 0; i < 2; i++) {
            maPhieuGiamGia.append(so.charAt(random.nextInt(so.length())));
        }
        maPhieuGiamGia.append(kiTu.charAt(random.nextInt(kiTu.length())));

        return maPhieuGiamGia.toString();
    }
}
