package com.example.matrixdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ServerController {

    @GetMapping("/api/server{account}")
    public void server(@MatrixVariable("account") String account) {

        assert account.equals("a");

    }


}
