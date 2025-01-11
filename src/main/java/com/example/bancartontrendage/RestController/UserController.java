package com.example.bancartontrendage.RestController;

import com.example.bancartontrendage.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private Service service;
}
