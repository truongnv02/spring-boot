package com.poly.lab1234.service.impl;

import com.poly.lab1234.model.DongVat;
import com.poly.lab1234.service.DongVatService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DongVatServiceImpl implements DongVatService {
    private List<DongVat> list = new ArrayList<>();

    public DongVatServiceImpl() {
        list.add(new DongVat(1, "Chó", 15, false, 15.0, "Hà Nội"));
        list.add(new DongVat(2, "Mèo", 15, true, 15.0, "Hà Nội"));
        list.add(new DongVat(3, "Gà", 1, false, 15.0, "Hà Nam"));
        list.add(new DongVat(4, "Trâu", 5, true, 15.0, "Nam Định"));
        list.add(new DongVat(5, "Lợn", 1, false, 15.0, "Thái Bình"));
    }

    @Override
    public List<DongVat> getAll() {
        return list;
    }

    @Override
    public DongVat detail(Integer id) {
        for (DongVat dv : list) {
            if(dv.getId().equals(id)) {
                return dv;
            }
        }
        return null;
    }

    @Override
    public void add(DongVat dongVat) {
        list.add(dongVat);
    }

    @Override
    public void update(DongVat dongVat) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(dongVat.getId())) {
                list.set(i, dongVat);
                break;
            }
        }
    }

    @Override
    public void delete(Integer id) {
        DongVat dv = detail(id);
        list.remove(dv);
    }

    @Override
    public DongVat search(String ten) {
        for(DongVat dv : list) {
            if(dv.getTen().equalsIgnoreCase(ten)) {
                return dv;
            }
        }
        return null;
    }
}
