package com.poly.truongnvph29176.repository;

import com.poly.truongnvph29176.entity.DanhSachYeuThich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DanhSachYeuThichRepository extends JpaRepository<DanhSachYeuThich, UUID> {
    @Query("select dsyt from DanhSachYeuThich dsyt order by dsyt.khachHang.ma asc ")
    Page<DanhSachYeuThich> sort(Pageable pageable);
}
