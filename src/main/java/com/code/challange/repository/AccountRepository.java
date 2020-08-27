package com.code.challange.repository;

import com.code.challange.db.AccountDB;
import com.code.challange.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AccountRepository {

    private static final Logger logger = LoggerFactory.getLogger(AccountRepository.class);

    @Inject
    private AccountDB accountDB;

    public Account add(Account entity) {
        logger.info("Try to persist new account");

        return accountDB.add(entity);
    }

    public Optional<Account> findById(String id) {
        logger.info("Try to find account by id");
        return accountDB.findById(id);
    }

    public Optional<Account> updateBalance(Optional<Account> account , Double amount){
        if(!account.isEmpty()){
            double result = account.get().getBalance().doubleValue() + amount.doubleValue();
            if( result >=0){
                account.get().setBalance(result);
            }else{
                throw new RuntimeException("insufficient balance");
            }
        }
        return account;
    }

    public Optional<List<Account>> getAll() {
        logger.info("Try to persist new account");

        return accountDB.getAll();
    }

    public void delete(String id) {
        accountDB.delete(id);
    }
}
