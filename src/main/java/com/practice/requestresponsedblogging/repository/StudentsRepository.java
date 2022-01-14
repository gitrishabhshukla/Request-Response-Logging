package com.practice.requestresponsedblogging.repository;

import com.practice.requestresponsedblogging.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends JpaRepository<Students,Integer> {

}
