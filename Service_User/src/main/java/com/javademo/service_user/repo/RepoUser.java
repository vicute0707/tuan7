package com.javademo.service_user.repo;

import com.javademo.service_user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoUser extends CrudRepository<User, Integer> {
}
