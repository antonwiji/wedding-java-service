package com.wedding.api.service.repository;

import com.wedding.api.service.entity.ValueUndanganEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValueUndanganRepository extends JpaRepository<ValueUndanganEntity, Long> {
    List<ValueUndanganEntity> findByIdUndangan(int id);
}
