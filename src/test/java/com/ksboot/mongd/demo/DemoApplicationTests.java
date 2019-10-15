package com.ksboot.mongd.demo;

import com.ksboot.mongd.demo.dao.UserRepository;
import com.ksboot.mongd.demo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void save(){
        List<User> list = new ArrayList<>();
        for (int i = 10; i < 15; i++) {
            list.add(new User(i, "name" + i, i));
        }
        userRepository.saveAll(list);
    }

    @Test
    public void get(){
        System.out.print("begin-----");
        Optional<User> ret = userRepository.findById(10L);
        if (ret.isPresent()){
            System.out.print( ret.get().getName());
        }
    }

    @Test
    public void like(){
        Page<User> ret= userRepository.findByNameLike("n", PageRequest.of(1, 5));
        //Assert.assertNotNull( ret);
        for(User user: ret.getContent()){
            System.out.println( user.getName());
        }
    }

    @Test
    public void contextLoads() {
    }

}
