package com.paolacodes.customerbaseapi.domain.service;

import com.paolacodes.customerbaseapi.domain.exception.BusinessException;
import com.paolacodes.customerbaseapi.domain.model.Client;
import com.paolacodes.customerbaseapi.domain.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ClientService {

    private ClientRepository clientRepository;

    public Client findClient(Long id){
        return clientRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Cliente nao encontrado"));
    }

    @Transactional
    public Client saveClient(Client client){
        boolean emailUsing = clientRepository.findByEmail(client.getEmail())
                .stream()
                .anyMatch(clientFound -> !clientFound.equals(client));

        if(emailUsing){
            throw new BusinessException("Ja existe um cliente cadastrado com esse e-mail");
        }

        return clientRepository.save(client);
    }

    @Transactional
    public void deleteClient(Long id){
        clientRepository.deleteById(id);

    }
}
