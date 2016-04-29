package com.example.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kimyongyeon on 2016-04-26.
 */
@RestController
@RequestMapping("/rest")
public class RestProcController {

    class User {
        String name;

        public void setName(String name) {
            this.name = name;
        }
    }

    Logger logger = LoggerFactory.getLogger(RestProcController.class);

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<Map> add(@RequestParam(value = "msg", defaultValue = "fail") String msg, UriComponentsBuilder ucb) {

        HttpHeaders header = new HttpHeaders();
        URI locationUri =
                ucb.path("/add/")
                .path("test")
                .build()
                .toUri();
        header.setLocation(locationUri);

        Map<String, Object> m = new HashMap<>();
        m.put("msg","성공");
        m.put("code","1");
        logger.info("msg : {}", msg);

        ResponseEntity<Map> responseEntity = new ResponseEntity(m, header, HttpStatus.CREATED);
        logger.info("responseEntity : {} ", responseEntity.toString());

        return responseEntity;
    }

    @RequestMapping(value = "/search")
    public ResponseEntity<Map> search(@RequestParam("id") String id) {

        HttpHeaders header = new HttpHeaders();

        Map<String, Object> m = new HashMap<>();
        m.put("msg","성공");
        m.put("code","1");
        //logger.info("msg : {}", fetchFacebookProfile(id));

        ResponseEntity<Map> responseEntity = new ResponseEntity(m, header, HttpStatus.CREATED);
        return responseEntity;
    }

    // 리소스 조회 : 오류
    public Profile fetchFacebookProfile(String id) {
        RestTemplate rest = new RestTemplate();
        return rest.getForObject("http://localhost:8080/rest/add?msg=1", Profile.class, id);
    }
}
