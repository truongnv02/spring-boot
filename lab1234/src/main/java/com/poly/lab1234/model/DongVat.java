package com.poly.lab1234.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DongVat {

    private Integer id;
    private String ten;
    private Integer tuoi;
    private Boolean gioiTinh;
    private Double canNang;
    private String khuVuc;
}
