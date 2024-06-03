package com.task.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "USERS")
public class User extends BaseEntityWithId {

  @Column(length = 80, unique = true)
  @Email
  public String email;

  @Column(length = 50)
  @NotBlank
  @Size(min = 3, max = 50)
  public String name;

  @Size(min = 3, max = 250)
  public String surname;

  @Column(length = 20)
  @NotBlank
  @Size(min = 3, max = 20)
  public String userId;

}
