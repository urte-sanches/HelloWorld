package com.example.HelloWorld.Controller;


import com.example.HelloWorld.DAO.DevelopersDAO;
import com.example.HelloWorld.Model.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping()
public class DevelopersController {

    private final DevelopersDAO developersDAO = new DevelopersDAO();



    @GetMapping("/developers")
    public String index() {
        List<Developer> developers = new ArrayList<Developer>();
        developers = developersDAO.index();

        StringBuilder allDevelopers = new StringBuilder();

        for(Developer developer : developers){
            allDevelopers.append(developer.toString());
        }
        return allDevelopers.toString();
    }


    @GetMapping("/developers/{id}")
    public String show(@PathVariable("id") int id) {
        Developer developer = developersDAO.show(id);
        return developer.toString();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/developers/new")
    public void create(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("nickname") String nickname,
                       @RequestParam("age") int age, @RequestParam("email") String email) {

        Developer developer = new Developer();

        developer.setId(id);
        developer.setName(name);
        developer.setNickname(nickname);
        developer.setAge(age);
        developer.setEmail(email);

        developersDAO.save(developer);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/developers/delete")
    public void delete(@RequestParam("id") int id){
        developersDAO.delete(id);
    }

}
