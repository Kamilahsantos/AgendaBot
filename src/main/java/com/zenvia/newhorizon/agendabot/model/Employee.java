package com.zenvia.newhorizon.agendabot.model;

import com.google.api.client.util.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {

  private Long id;
  private String name;
  private String surname;
  private String service;
  private  SERVICE_TYPE service_type;
  private Long value;
  private DAYS_OF_WEEK days_of_week;
  private DateTime dateTime;

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

  @Column(name = "service", length = 255, nullable = false)
  @NotNull(message = "Please input a service")
  @Size(max = 255)
  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }

  @Column(name = "service_type", length = 255, nullable = false)
  @NotNull(message = "Please input a service_type")
  @Size(max = 255)
  public SERVICE_TYPE getService_type() {
    return service_type;
  }

  public void setService_type(SERVICE_TYPE service_type) {
    this.service_type = service_type;
  }

  @Column(name = "value", length = 255, nullable = false)
  @NotNull(message = "Please input a value")
  public Long getValue() {
    return value;
  }

  public void setValue(Long value) {
    this.value = value;
  }

  @Column(name = "days_of_week",  nullable = false)
  @NotNull(message = "Please input a days_of_week")
  public DAYS_OF_WEEK getDays_of_week() {
    return days_of_week;
  }

  public void setDays_of_week(DAYS_OF_WEEK days_of_week) {
    this.days_of_week = days_of_week;
  }

  @Column(name = "dateTime",  nullable = false)
  @NotNull(message = "Please input a dateTime")
  public DateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(DateTime dateTime) {
    this.dateTime = dateTime;
  }

  public Employee() {
  }

  public Employee(Long id, String name, String surname, String service, SERVICE_TYPE service_type, Long value, DAYS_OF_WEEK days_of_week, DateTime dateTime) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.service = service;
    this.service_type = service_type;
    this.value = value;
    this.days_of_week = days_of_week;
    this.dateTime = dateTime;
  }

  @Override
  public String toString() {
    return "Employee [id=" + id + ", name=" + name +  ", surname=" + surname + ", service=" + service + ", service_type=" + service_type + ", value=" + value + ", days_of_week=" + days_of_week +
      ", dateTime" +   dateTime  + "]";
  }
}
