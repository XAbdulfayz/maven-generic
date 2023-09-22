package com.xa.MapperAndGeneric.repository;

import com.xa.MapperAndGeneric.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {



}
