package com.example.matrixdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class ClientController {

    @Autowired
    private FeignDemo feignDemo;

    @GetMapping("/api/client")
    public void example() {

        feignDemo.server("a");


    }

}
