package com.poly.truongnvph29176.crud.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien {
    @NotBlank(message = "Không được để trống")
    private String mssv;

    @NotBlank(message = "Không được để trống")
    private String ten;

    @NotNull(message = "Không được để trống")
    @Min(value = 18, message = "Tuổi phải lớn hơn 18")
    @Max(value = 100, message = "Tuổi nhỏ hơn 100")
    private Integer tuoi;

    @NotBlank(message = "Không được để trống")
    private String diaChi;

    private Boolean gioiTinh;
}
