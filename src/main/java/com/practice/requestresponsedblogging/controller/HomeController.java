package com.practice.requestresponsedblogging.controller;

import com.practice.requestresponsedblogging.entity.Students;
import com.practice.requestresponsedblogging.repository.LogRepository;
import com.practice.requestresponsedblogging.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class HomeController {

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private LogRepository logRepository;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Students request){
        return new ResponseEntity<>(studentsRepository.save(request), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<?> get(){
        return new ResponseEntity<>(studentsRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping("/logs")
    public ResponseEntity<?> getLogData(){
        return new ResponseEntity<>(logRepository.findAll(),HttpStatus.OK);
    }
}
