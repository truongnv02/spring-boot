package com.poly.truongnvph29176.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DanhSachYeuThich")
public class DanhSachYeuThich {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "MaDanhSach")
    private UUID ma;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "NguoiSoHuu")
    private KhachHang khachHang;
}
