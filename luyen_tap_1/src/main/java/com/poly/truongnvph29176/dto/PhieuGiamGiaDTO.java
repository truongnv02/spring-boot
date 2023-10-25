package com.poly.truongnvph29176.dto;

import com.poly.truongnvph29176.entity.KhachHang;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PhieuGiamGiaDTO {
    @NotBlank(message = "Khong dc de trong")
    private String maPhieu;

    @NotBlank(message = "Khong dc de trong")
    private String tenPhieu;

    private Date ngayBatDau;

    private Date ngayKetThuc;

    @NotBlank(message = "Khong dc de trong")
    private String giaTriGiam;

    @NotBlank(message = "Khong dc de trong")
    private String giaTriGiamToiDa;

    private Integer trangThai;

    private KhachHang khachHang;

    public boolean isNgayKetThucAfterNgayBatDau() {
        return ngayKetThuc != null && ngayBatDau != null && ngayKetThuc.after(ngayBatDau);
    }
}
