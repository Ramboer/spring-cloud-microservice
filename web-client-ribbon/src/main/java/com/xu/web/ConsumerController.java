package com.xu.web;

import com.xu.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return restTemplate.getForEntity("http://USER-SERVICE/add?name=xu", String.class).getBody();
    }

    /**
     * 使用Hystrix
     */
    @RequestMapping(value = "/addV2", method = RequestMethod.GET)
    public String addV2() {
        return userService.addService();
    }


}