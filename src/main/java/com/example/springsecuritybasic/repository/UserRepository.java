package com.example.springsecuritybasic.repository;

import com.example.springsecuritybasic.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Mapper
@Repository
public interface UserRepository {

    @Select("select * from account_tb where email like #{email}")
    Account findUserByEmail(String email);
}
