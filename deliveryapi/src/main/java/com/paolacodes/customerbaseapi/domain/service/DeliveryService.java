package com.paolacodes.customerbaseapi.domain.service;

import com.paolacodes.customerbaseapi.domain.exception.BusinessException;
import com.paolacodes.customerbaseapi.domain.model.Client;
import com.paolacodes.customerbaseapi.domain.model.Delivery;
import com.paolacodes.customerbaseapi.domain.model.StatusDelivery;
import com.paolacodes.customerbaseapi.domain.repository.ClientRepository;
import com.paolacodes.customerbaseapi.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class DeliveryService {

    private ClientService clientService;
    private DeliveryRepository deliveryRepository;

    @Transactional
    public Delivery requestDelivery(Delivery delivery){
       Client client = clientService.findClient(delivery.getClient().getId());

        delivery.setClient(client);
        delivery.setStatusDelivery(StatusDelivery.PENDING);
        delivery.setDateOrder(OffsetDateTime.now());

        return deliveryRepository.save(delivery);
    }
}
