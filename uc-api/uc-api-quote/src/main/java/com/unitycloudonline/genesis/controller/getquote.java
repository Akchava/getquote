package com.unitycloudonline.genesis.controller;

import com.unitycloudonline.genesis.service.Generatequote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/getquote")
public class getquote {


    public final Generatequote generatequote;

    @Autowired
    public getquote(Generatequote generatequote) {
        this.generatequote = generatequote;
    }
    @GetMapping
    public String getquote() {
        return generatequote.newQuote();
    }

}
