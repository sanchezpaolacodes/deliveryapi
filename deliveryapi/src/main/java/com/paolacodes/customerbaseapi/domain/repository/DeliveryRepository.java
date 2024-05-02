package com.paolacodes.customerbaseapi.domain.repository;

import com.paolacodes.customerbaseapi.domain.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository <Delivery, Long> {
}
