package com.example.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kimyongyeon on 2016-04-26.
 */
@RestController
@RequestMapping("/rest")
public class RestProcController {

    Logger logger = LoggerFactory.getLogger(RestProcController.class);

    @RequestMapping("/add")
    public Map add(@RequestParam("msg") String msg) {
        Map<String, Object> m = new HashMap<>();
        m.put("msg","성공");
        m.put("code","1");
        logger.info("msg : {} ", msg);
        return m;
    }
}
