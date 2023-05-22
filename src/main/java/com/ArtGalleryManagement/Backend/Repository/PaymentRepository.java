package com.ArtGalleryManagement.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ArtGalleryManagement.Backend.Entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
	Payment findByUserEmail(String userEmail);
}
