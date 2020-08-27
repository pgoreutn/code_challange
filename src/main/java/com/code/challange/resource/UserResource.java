package com.code.challange.resource;

import com.code.challange.dto.UserDto;
import com.code.challange.exception.ConstraintViolationResponse;
import com.code.challange.facade.UserFacade;
import com.code.challange.model.User;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;


@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "users")
public class UserResource {

    @Inject
    UserFacade userFacade;

    @POST
    @APIResponse(responseCode = "201", description = "If user is successfully registered")
    @APIResponse(responseCode = "400", content = @Content(schema = @Schema(allOf = ConstraintViolationResponse.class)))
    public Response create(@Valid UserDto dto) {
        userFacade.create(dto);
        return Response.status(Response.Status.CREATED).build();
    }


    @GET
    @APIResponse(responseCode = "201", description = "If user is successfully registered")
    @APIResponse(responseCode = "400", content = @Content(schema = @Schema(allOf = ConstraintViolationResponse.class)))
    public Uni<Collection<User>> getAll() {

        return userFacade.getAll();
    }

    @DELETE
    @Path("/{email}")
    @APIResponse(responseCode = "201", description = "delete a user and his account ")
    @APIResponse(responseCode = "400", content = @Content(schema = @Schema(allOf = ConstraintViolationResponse.class)))
    public void delete(@PathParam("email") String email ) {
        userFacade.delete(email);
    }


}