package com.poly.truongnvph29176.repository;

import com.poly.truongnvph29176.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
    @Query("select kh from KhachHang kh where kh.tenKhachHang=:ten and kh.hangKhachHang.maHang=:maHang")
    Page<KhachHang> search(String ten, Integer maHang, Pageable pageable);
}
