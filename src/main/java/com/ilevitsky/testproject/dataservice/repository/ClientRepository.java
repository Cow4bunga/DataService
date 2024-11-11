package com.ilevitsky.testproject.dataservice.repository;

import com.ilevitsky.testproject.dataservice.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findClientByGuidAndAgency(String guid, String agency);

    @Query(value = "SELECT * FROM client ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Client> findRandomClientByGuid();
}
