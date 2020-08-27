package com.code.challange.facade;

import com.code.challange.ModelMapperUtils;
import com.code.challange.dto.AccountDto;
import com.code.challange.model.Account;
import com.code.challange.repository.AccountRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class AccountBalanceFacade {

    private final AccountRepository accountRepository;

    @Inject
    public AccountBalanceFacade(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account create(AccountDto dto){
        Optional<Account> account = ModelMapperUtils.map(dto, Account.class);
        account.get().setId(UUID.randomUUID().toString());

        return  accountRepository.add(account.orElseThrow());
    }

    public Optional<Account> updateBalance(String accountId , Double value){
        Optional<Account> account = accountRepository.findById(accountId);
        return  accountRepository.updateBalance(account , value);
    }

    public List<AccountDto> getAll(){


        List<AccountDto> accountDtoList = new ArrayList<>();
        Optional<List<Account>> x = accountRepository.getAll();
        accountRepository.getAll().get().stream()
                .forEach(r->{
                    AccountDto dto = new AccountDto(r.getId(),r.getAccountNumber(),r.getBalance(),r.getUser());

                    accountDtoList.add(dto);
                });
        return  accountDtoList;
    }

    public void delete(String id) {
        accountRepository.delete(id);
    }
}
