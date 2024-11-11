package com.ilevitsky.testproject.dataservice.controller;

import com.ilevitsky.testproject.dataservice.dto.ClientRequestPayload;
import com.ilevitsky.testproject.dataservice.dto.ClientResponse;
import com.ilevitsky.testproject.dataservice.entity.Client;
import com.ilevitsky.testproject.dataservice.entity.ClientNote;
import com.ilevitsky.testproject.dataservice.service.DataRetrievalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/export")
public class ExportController {
    private final DataRetrievalService dataRetrievalService;

    @PostMapping("/clients")
    public ResponseEntity<ClientResponse<Client>> getAllClients() {
        return new ResponseEntity<>(dataRetrievalService.getAllClients(), HttpStatus.OK);
    }

    @PostMapping("/notes")
    public ResponseEntity<ClientResponse<ClientNote>> getAllClientNotes(
            @RequestBody ClientRequestPayload payload) {
        return new ResponseEntity<>(dataRetrievalService.getAllNotesForClient(payload), HttpStatus.OK);
    }
}
