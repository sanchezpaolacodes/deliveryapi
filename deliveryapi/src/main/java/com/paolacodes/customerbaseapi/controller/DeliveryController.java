package com.paolacodes.customerbaseapi.controller;

import com.paolacodes.customerbaseapi.domain.model.Client;
import com.paolacodes.customerbaseapi.domain.model.Delivery;
import com.paolacodes.customerbaseapi.domain.repository.DeliveryRepository;
import com.paolacodes.customerbaseapi.domain.service.DeliveryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private DeliveryRepository deliveryRepository;
    private DeliveryService deliveryService;

    @GetMapping
    public List<Delivery> findAllDeliveries(){
        return deliveryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> findDeliveryById(@PathVariable Long id){
        return deliveryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery requestDelivery(@Valid @RequestBody Delivery delivery){
        return deliveryService.requestDelivery(delivery);
    }
}
