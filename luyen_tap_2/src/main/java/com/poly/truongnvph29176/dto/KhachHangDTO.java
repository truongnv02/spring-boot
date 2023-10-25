package com.poly.truongnvph29176.dto;

import com.poly.truongnvph29176.entity.HangKhachHang;
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
public class KhachHangDTO {
    @NotBlank(message = "Không được để trống")
    private String tenKhachHang;

    @NotBlank(message = "Không được để trống")
    private String sdt;

    private String email;

    private Integer gioiTinh;

    private HangKhachHang hangKhachHang;
}
