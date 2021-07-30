package com.game.BTVN.Reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.BTVN.Model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{

}