package com.ilevitsky.testproject.dataservice.service;

import com.ilevitsky.testproject.dataservice.dto.ClientRequestPayload;
import com.ilevitsky.testproject.dataservice.dto.ClientResponse;
import com.ilevitsky.testproject.dataservice.entity.Client;
import com.ilevitsky.testproject.dataservice.entity.ClientNote;

import java.util.List;

public interface DataRetrievalService {
    ClientResponse<Client> getAllClients();

    ClientResponse<ClientNote> getAllNotesForClient(ClientRequestPayload payload);
}
