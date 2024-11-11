package com.ilevitsky.testproject.dataservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client {

  @Id private String guid;

  private String agency;

  private String firstName;

  private String lastName;

  private String status;

  @Column(name = "dob")
  private LocalDate dateOfBirth;

  @Column(name = "created_date_time")
  private LocalDateTime createdDateTime;
}
