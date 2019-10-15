package com.ksboot.mongd.demo.controller;

import com.ksboot.mongd.demo.dao.UserRepository;
import com.ksboot.mongd.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/get/{id}")
    public User getUser(@PathVariable long id) {
        Optional<User> ret = userRepository.findById(id);
        if (ret.isPresent()){
            return ret.get();
        }
        return null;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        userRepository.deleteById(id);
        return "delete sucess";
    }

    @RequestMapping("/add")
    public String insert() {
        User user =new User(16, ""+16, 16);
        userRepository.insert(user);
        return "sucess";
    }

    @RequestMapping("/insert")
    public String insertAll() {
        List<User> list = new ArrayList<>();
        for (int i = 10; i < 15; i++) {
            list.add(new User(i, "" + i, i));
        }
        userRepository.insert(list);
        return "sucess";
    }

    @RequestMapping("/find/all")
    public List<User> find(){
        return userRepository.findAll();
    }

    @RequestMapping("/find/{start}")
    public List<User> findByPage(@PathVariable int start, User user){
        Pageable pageable= PageRequest.of(start, 2);
        Page<User> ret= userRepository.findAll(pageable);
        return ret.getContent();
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable int id){
        User user =new User(id, ""+1, 1);
        userRepository.save(user);
        return "sucess";
    }
}
