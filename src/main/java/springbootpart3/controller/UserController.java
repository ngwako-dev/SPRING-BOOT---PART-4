package springbootpart3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api")

public class UserController {

@GetMapping("/repo")
    public String gitApi(){


        RestTemplate restTemplate=new RestTemplate();

        String url="https://api.github.com";

        ResponseEntity<String> response = restTemplate.getForEntity(url+"/users/Ngwako-dev/repos", String.class);
        System.out.println("response "+response.toString());


        return response.toString();

    }

}
