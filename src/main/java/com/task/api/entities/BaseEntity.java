package com.task.api.entities;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;

@MappedSuperclass
public class BaseEntity implements TrackingState {

  @Column(name = "created_by")
  public String createdBy;

  @Column(name = "created_on")
  public ZonedDateTime createdOn;

  @Version
  public Integer optLock;

  @Column(name = "updated_by")
  public String updatedBy;

  @Column(name = "updated_on")
  public ZonedDateTime updatedOn;

  @Override
  public String getCreatedBy() {
    return createdBy;
  }

  @Override
  public String getCreatedOn() {
    return createdOn.toString();
  }

  @Override
  public Integer getOptLock() {
    return optLock;
  }

  @Override
  public String getUpdatedOn() {
    return updatedOn.toString();
  }
}
