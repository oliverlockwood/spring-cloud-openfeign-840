package com.example.matrixdemo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;


@FeignClient(url = "http://localhost:8080", name="name")
public interface FeignDemo {

    @GetMapping(value = "/api/server{account}")
    void server(@MatrixVariable("account") String account);

}
