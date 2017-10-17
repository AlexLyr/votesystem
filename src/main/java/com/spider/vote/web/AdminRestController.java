package com.spider.vote.web;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.spider.vote.web.AdminRestController.ADMIN_REST_URL;


@RestController
@RequestMapping(value = ADMIN_REST_URL)
public class AdminRestController {

    public static final String ADMIN_REST_URL="rest/admin";





}
