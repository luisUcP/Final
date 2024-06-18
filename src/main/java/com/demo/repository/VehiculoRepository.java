package com.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.domain.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long>{}