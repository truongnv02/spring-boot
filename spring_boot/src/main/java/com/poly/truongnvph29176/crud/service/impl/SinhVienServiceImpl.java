package com.poly.truongnvph29176.crud.service.impl;

import com.poly.truongnvph29176.crud.model.SinhVien;
import com.poly.truongnvph29176.crud.service.SinhVienService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SinhVienServiceImpl implements SinhVienService {

    private List<SinhVien> listSinhVien = new ArrayList<>();

    public SinhVienServiceImpl() {
        // add cac phan tu
        listSinhVien.add(new SinhVien("HE130461", "Nguyen Thuy Hang", 10, "Ha Noi", false));
        listSinhVien.add(new SinhVien("HE130462", "Nguyen Hoang Tien", 11, "Ha Noi1", true));
        listSinhVien.add(new SinhVien("HE130463", "Nguyen Anh Dung", 15, "Ha Noi3", true));
        listSinhVien.add(new SinhVien("HE130464", "Vu Van Nguyen", 14, "Ha Noi6", true));
        listSinhVien.add(new SinhVien("HE130465", "Tran Tuan Phong", 20, "Ha Noi7", true));
    }

    @Override
    public List<SinhVien> getAll() {
        return listSinhVien;
    }

    @Override
    public void addSinhVien(SinhVien sinhVien) {
        listSinhVien.add(sinhVien);
    }

    @Override
    public SinhVien detailSinhVien(String ma) {
        for (SinhVien sv : listSinhVien) {
            if (sv.getMssv().equalsIgnoreCase(ma)) {
                return sv;
            }
        }
        return null;
    }

    @Override
    public SinhVien search(String ten) {
        for(SinhVien sv : listSinhVien) {
            if(sv.getTen().equals(ten)) {
                return sv;
            }
        }
        return null;
    }

    @Override
    public void deleteSinhVien(String ma) {
        SinhVien sv = detailSinhVien(ma);
        listSinhVien.remove(sv);
    }

    @Override
    public void updateSinhVien( SinhVien sinhVien) {
        for(int i = 0; i < listSinhVien.size(); i++) {
            if (listSinhVien.get(i).getMssv().equalsIgnoreCase(sinhVien.getMssv())) {
                listSinhVien.set(i, sinhVien);
                break;
            }
        }
    }
}
