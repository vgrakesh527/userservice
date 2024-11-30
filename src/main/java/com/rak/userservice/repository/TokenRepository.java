package com.rak.userservice.repository;

import com.rak.userservice.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {

    public Token findByValue(String token);
}
