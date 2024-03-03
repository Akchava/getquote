package com.unitycloudonline.snapshot.quote;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/getquote")
public class getquote {
    @GetMapping
    public String getquote() {
        return ("test");
    }

}
