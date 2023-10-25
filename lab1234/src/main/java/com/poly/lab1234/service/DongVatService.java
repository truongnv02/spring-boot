package com.poly.lab1234.service;

import com.poly.lab1234.model.DongVat;

import java.util.List;

public interface DongVatService {
    List<DongVat> getAll();

    DongVat detail(Integer id);

    void add(DongVat dongVat);

    void update(DongVat dongVat);

    void delete(Integer id);

    DongVat search(String ten);
}
