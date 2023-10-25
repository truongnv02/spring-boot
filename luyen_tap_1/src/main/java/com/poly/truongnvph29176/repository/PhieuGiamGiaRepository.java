package com.poly.truongnvph29176.repository;

import com.poly.truongnvph29176.entity.PhieuGiamGia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PhieuGiamGiaRepository extends JpaRepository<PhieuGiamGia, String> {
    @Query("select pgg from PhieuGiamGia pgg where pgg.ngayBatDau between :startDate and :endDate and pgg.khachHang.ma=:ma")
    Page<PhieuGiamGia> search(Date startDate, Date endDate, Long ma, Pageable pageable);
}
