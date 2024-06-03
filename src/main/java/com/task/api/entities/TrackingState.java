package com.task.api.entities;

public interface TrackingState {
  String getCreatedBy();

  String getCreatedOn();

  Integer getOptLock();

  String getUpdatedOn();
}
