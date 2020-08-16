package com.techshard.batch.dao.repository;

import com.techshard.batch.dao.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBankRepository extends JpaRepository<Bank, Long> {

}
