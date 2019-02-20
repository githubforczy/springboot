package com.springboot.day05;

import com.springboot.day05.controller.WebController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class ControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new WebController()).build();
    }

    /*@Test
    public void test() throws Exception {
        String responseResult = mockMvc.perform(MockMvcRequestBuilders.post("/user").accept(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse().getContentAsString();
        System.out.println("result:" + responseResult);
    }

    @Test
    public void getUserList() throws Exception {
        String responseResult = mockMvc.perform(MockMvcRequestBuilders.post("/getUsers").accept(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse().getContentAsString();
        System.out.println("result:" + responseResult);
    }*/

    @Test
    public void setUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/saveUser").param("name", "").param("age", "15").param("pass", ""));
    }
}
