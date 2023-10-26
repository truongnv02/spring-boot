package com.poly.truongnvph29176.dto;

import com.poly.truongnvph29176.entity.KhachHang;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DanhSachYeuThichDTO {
    @NotBlank(message = "không được để trống")
    private String ghiChu;

    private Integer trangThai;

    private KhachHang khachHang;
}
