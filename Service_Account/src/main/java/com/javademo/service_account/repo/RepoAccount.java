package com.javademo.service_account.repo;

import com.javademo.service_account.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface RepoAccount extends CrudRepository<Account,Integer> {
}
