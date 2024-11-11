package com.ilevitsky.testproject.dataservice.service.impl;

import com.ilevitsky.testproject.dataservice.dto.ClientRequestPayload;
import com.ilevitsky.testproject.dataservice.dto.ClientResponse;
import com.ilevitsky.testproject.dataservice.entity.Client;
import com.ilevitsky.testproject.dataservice.entity.ClientNote;
import com.ilevitsky.testproject.dataservice.exception.ClientNotFoundException;
import com.ilevitsky.testproject.dataservice.repository.ClientNoteRepository;
import com.ilevitsky.testproject.dataservice.repository.ClientRepository;
import com.ilevitsky.testproject.dataservice.service.DataRetrievalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataRetrievalServiceImpl implements DataRetrievalService {
    private final ClientRepository clientRepository;
    private final ClientNoteRepository clientNoteRepository;

    @Override
    public ClientResponse<Client> getAllClients() {
        return new ClientResponse<>(clientRepository.findAll());
    }

    @Override
    public ClientResponse<ClientNote> getAllNotesForClient(ClientRequestPayload payload) {
        var data = clientRepository.findRandomClientByGuid();
        /*
         This may only be used if we know params, but since api calls are just scheduled methods,
         we cannot provide params for request body manually, only hardcode them.
                var data =
                        clientRepository.findClientByGuidAndAgency(payload.getClientGuid(), payload.getAgency());
        */
        if (data.isPresent()) {
            return new ClientResponse<>(clientNoteRepository.findClientNotesByClientGuid(
                    data.get().getGuid(), payload.getDateFrom(), payload.getDateTo()));
        } else {
            log.error(
                    "No data for client with guid {} and agency {}!", payload.getClientGuid(), payload.getAgency());
            throw new ClientNotFoundException(
                    String.format(
                            "No client with guid %s and agency %s!",
                            payload.getClientGuid(), payload.getAgency()));
        }
    }
}
