package com.user.service.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
        Optional<User> findById(Long id);
        @Transactional
        User save(User user);
}
