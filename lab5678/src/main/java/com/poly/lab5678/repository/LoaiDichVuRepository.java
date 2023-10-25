package com.poly.lab5678.repository;

import com.poly.lab5678.entity.LoaiDichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoaiDichVuRepository extends JpaRepository<LoaiDichVu, UUID> {
}
