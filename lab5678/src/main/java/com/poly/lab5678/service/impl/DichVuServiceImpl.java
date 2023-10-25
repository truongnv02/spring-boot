package com.poly.lab5678.service.impl;

import com.poly.lab5678.entity.DichVu;
import com.poly.lab5678.repository.DichVuRepository;
import com.poly.lab5678.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class DichVuServiceImpl implements DichVuService {
    @Autowired
    private DichVuRepository dichVuRepository;

    @Override
    public List<DichVu> getAll() {
        return dichVuRepository.findAll();
    }

    @Override
    public DichVu save(DichVu dichVu) {
//        String maDichVu = generateMaDichVu();
//        DichVu dv = new DichVu();
//        dv.setMa(maDichVu);
//        dv.setLoaiDichVu(dichVu.getLoaiDichVu());
//        dv.setTen(dichVu.getTen());
//        dv.setDonGia(dichVu.getDonGia());
//        dv.setNgayTao(dichVu.getNgayTao());
//        dv.setTrangThai(dichVu.getTrangThai());
        return dichVuRepository.save(dichVu);
    }

    @Override
    public DichVu update(DichVu dichVu) {
        return dichVuRepository.save(dichVu);
    }

    @Override
    public String generateMaDichVu() {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        String upperCaseCharacters = characters.toUpperCase();
        String digits = "0123456789";
        String specialCharacters = "!@#$%^&*()_+";

        Random random = new Random();

        StringBuilder maDichVu = new StringBuilder();

        // Generate 4 lowercase characters
        for (int i = 0; i < 4; i++) {
            maDichVu.append(characters.charAt(random.nextInt(characters.length())));
        }

        // Generate 3 uppercase characters
        for (int i = 0; i < 3; i++) {
            maDichVu.append(upperCaseCharacters.charAt(random.nextInt(upperCaseCharacters.length())));
        }

        // Generate 2 digits
        for (int i = 0; i < 2; i++) {
            maDichVu.append(digits.charAt(random.nextInt(digits.length())));
        }

        // Generate 1 special character
        maDichVu.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));

        return maDichVu.toString();
    }

    @Override
    public DichVu findById(UUID id) {
        return dichVuRepository.findById(id).orElse(null);
    }

    @Override
    public List<DichVu> findByName(String ten) {
        return dichVuRepository.findByName(ten);
    }

    @Override
    public List<DichVu> findByNgayTaoBetween(Date startDate) {
        return dichVuRepository.findByNgayTaoBetween(startDate);
    }

    @Override
    public List<DichVu> findDichVuByNameAndLoaiDichVu(String ten, UUID id) {
        return dichVuRepository.findDichVuByNameAndLoaiDichVu(ten, id);
    }

    @Override
    public void delete(UUID id) {
        dichVuRepository.deleteById(id);
    }

}
