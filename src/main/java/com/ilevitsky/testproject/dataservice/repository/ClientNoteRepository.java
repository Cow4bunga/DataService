package com.ilevitsky.testproject.dataservice.repository;

import com.ilevitsky.testproject.dataservice.entity.ClientNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClientNoteRepository extends JpaRepository<ClientNote, String> {
    @Query(
            value =
                    "SELECT * FROM public.client_note "
                            + "WHERE client_guid = :clientGuid "
                            + "AND created_date_time BETWEEN :dateFrom AND :dateTo",
            nativeQuery = true)
    List<ClientNote> findClientNotesByClientGuid(
            @Param("clientGuid") String clientGuid,
            @Param("dateFrom") LocalDate dateFrom,
            @Param("dateTo") LocalDate dateTo);
}
