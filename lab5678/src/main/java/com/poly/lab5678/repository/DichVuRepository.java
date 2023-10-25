package com.poly.lab5678.repository;

import com.poly.lab5678.entity.DichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface DichVuRepository extends JpaRepository<DichVu, UUID> {
    @Query("select dv from DichVu dv where dv.ten=:ten")
    List<DichVu> findByName(String ten);

    @Query("select dv from DichVu dv where dv.ten=:ten and dv.loaiDichVu.id=:id")
    List<DichVu> findDichVuByNameAndLoaiDichVu(String ten, UUID id);

    @Query("select dv from DichVu dv where dv.ngayTao=:startDate")
    List<DichVu> findByNgayTaoBetween(Date startDate);
}
