package com.example.Restaurant.management.service.API.repository;

import com.example.Restaurant.management.service.API.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin,Long> {
}
