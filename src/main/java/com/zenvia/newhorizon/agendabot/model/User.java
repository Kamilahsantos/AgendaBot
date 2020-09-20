package com.zenvia.newhorizon.agendabot.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {


  private Long id;
  private String name;
  private String surname;
  private String password;

  @Column(name = "email", length = 255, nullable = false)
  @NotNull(message = "Please input a email")
  @Size(max = 255)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  private String email;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "name", length = 255, nullable = false)
  @NotNull(message = "Please input a name")
  @Size(max = 255)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
@Column(name = "surname", length = 255, nullable = false)
  @NotNull(message = "Please input a surname")
  @Size(max = 255)
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  @Column(name = "password", length = 255, nullable = false)
  @NotNull(message = "Please input a password")
  @Size(max = 255)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User(Long id, String name, String surname, String password, String email) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.password = password;
    this.email = email;
  }

  public User() {
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", email=" + email + ", name=" + name + ", surname=" + surname +
      ", password=" + password    + "]";
  }

}
