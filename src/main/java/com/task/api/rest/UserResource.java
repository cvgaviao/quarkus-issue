package com.task.api.rest;

import static com.task.api.rest.MessageConstants.MSG_INVALID_PAYLOAD;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.Status;

import com.task.api.dtos.UserDto;
import com.task.api.dtos.UserNoIdDto;
import com.task.api.mappers.UserMapper;
import com.task.api.repositories.UserRepo;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.resteasy.reactive.links.InjectRestLinks;
import io.quarkus.resteasy.reactive.links.RestLinkType;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Tag(name = "Users")
public class UserResource {

  final UserMapper mapper;
  final UserRepo userRepo;

  @Inject
  public UserResource(UserRepo userRepo, UserMapper mapper) {
    this.userRepo = userRepo;
    this.mapper = mapper;
  }

  @POST
  @InjectRestLinks(RestLinkType.INSTANCE)
  public Uni<RestResponse<UserDto>> create(@Valid UserNoIdDto userNoIdDto) {
    if (userNoIdDto == null) {
      throw new WebApplicationException(MSG_INVALID_PAYLOAD, 422);
    }

    return Panache.withTransaction(() -> userRepo.persist(mapper.toNoIdEntity(userNoIdDto)))
        .map(created -> RestResponse.status(Status.CREATED, mapper.toDto(created)));
  }
}
