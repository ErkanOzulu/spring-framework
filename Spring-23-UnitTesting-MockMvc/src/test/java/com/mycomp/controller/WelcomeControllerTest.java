package com.mycomp.controller;

import jdk.jfr.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//it means I don't need other classes beans
@WebMvcTest(WelcomeController.class)
class WelcomeControllerTest {


    @Autowired
    private MockMvc mvc;

    @Test
    void welcome() throws Exception {

        // basic integration test

        //call  /welcome endpoint

        //verify "welcome"

        RequestBuilder request= MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(request).andReturn();

        assertEquals(200,result.getResponse().getStatus());
        assertEquals("welcome",result.getResponse().getContentAsString());


    }


    @Test
    void welcome2() throws Exception {
    //common way or preferred way of implementation
        RequestBuilder request = MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("welcome"))
                .andReturn();


    }


}