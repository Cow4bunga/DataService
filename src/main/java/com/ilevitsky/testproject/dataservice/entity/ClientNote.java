package com.ilevitsky.testproject.dataservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client_note")
public class ClientNote {

  @Id private String guid;

  @Column(nullable = true, length = 4000)
  private String comments;

  @Column(name = "modified_date_time")
  private LocalDateTime modifiedDateTime;

  @Column(name="client_guid")
  private String clientGuid;

  @Column(nullable = false)
  private LocalDateTime datetime;

  @Column(name = "logged_user")
  private String loggedUser;

  @Column(name = "created_date_time", nullable = false)
  private LocalDateTime createdDateTime;
}
