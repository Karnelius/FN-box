package com.mycompany.box;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoxService {

    @Autowired private BoxRepository repo;

    public List<Box> listAll(){
        return (List<Box>) repo.findAll();
    }

    public void save(Box box) {
        repo.save(box);
    }
}
