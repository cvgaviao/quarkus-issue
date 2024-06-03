package com.task.api.repositories;

import com.task.api.entities.User;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepo implements PanacheRepository<User> {

}
