package com.code.challange.resource;

import com.code.challange.dto.AccountDto;
import com.code.challange.exception.ConstraintViolationResponse;
import com.code.challange.facade.AccountBalanceFacade;
import com.code.challange.model.Account;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "accounts")
public class AccountBalanceResource {

    @Inject
    AccountBalanceFacade accountBalanceFacade;

    @POST
    @APIResponse(responseCode = "201", description = "Create a new empty account")
    @APIResponse(responseCode = "400", content = @Content(schema = @Schema(allOf = ConstraintViolationResponse.class)))
    public Account create(@Valid AccountDto dto) {
        return accountBalanceFacade.create(dto);
    }


    @GET
    @APIResponse(responseCode = "201", description = "return all accounts")
    @APIResponse(responseCode = "400", content = @Content(schema = @Schema(allOf = ConstraintViolationResponse.class)))
    public List<AccountDto> getAll() {
        return accountBalanceFacade.getAll();
    }

    @PUT
    @Path("{id}/balance/{amount}")
    @APIResponse(responseCode = "201", description = "update account balance")
    @APIResponse(responseCode = "400", content = @Content(schema = @Schema(allOf = ConstraintViolationResponse.class)))
    public Account create(@PathParam("id") String id , @PathParam("amount") Double amount) {
        return accountBalanceFacade.updateBalance(id, amount).get();
    }

    @DELETE
    @Path("/{id}")
    @APIResponse(responseCode = "201", description = "delete an account")
    @APIResponse(responseCode = "400", content = @Content(schema = @Schema(allOf = ConstraintViolationResponse.class)))
    public void delete(@PathParam("id") String id ) {
        accountBalanceFacade.delete(id);
    }
}