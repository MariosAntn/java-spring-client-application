package com.mapfintech.intern;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByClientId(int id);
    Optional<Client> findByClientUserName(String userName);
}
