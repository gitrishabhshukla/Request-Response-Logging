package com.practice.requestresponsedblogging.repository;

import com.practice.requestresponsedblogging.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log,Integer> {

}
