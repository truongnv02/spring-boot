package com.poly.truongnvph29176.crud_jpa.repository;

import com.poly.truongnvph29176.crud_jpa.entity.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CuaHangRepository extends JpaRepository<CuaHang, UUID> {
}
