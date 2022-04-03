package com.mycompany;


import com.mycompany.box.Box;
import com.mycompany.box.BoxRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)

public class BoxRepositoryTests {
    @Autowired private BoxRepository repo;

    @Test
    public void testAddNew(){
        Box box = new Box();
        box.setReciever("Test");
        box.setColor(54321);
        box.setCost(2.5f);
        box.setWeight(2.1f);

        Box savedBox = repo.save(box);

        Assertions.assertThat(savedBox).isNotNull();
        Assertions.assertThat(savedBox.getId()).isGreaterThan(0);
    }

    @Test
    public void listAll(){
        Iterable<Box> boxes = repo.findAll();
        Assertions.assertThat(boxes).hasSizeGreaterThan(0);

        for(Box box : boxes){
            System.out.println(box);
        }
    }

    @Test
    public void testUpdate(){
        Integer boxId = 1;
        Optional<Box> optionalId = repo.findById(boxId);
        Box box = optionalId.get();
        box.setColor(1111);
        repo.save(box);

        Box updatedBox = repo.findById(boxId).get();
        Assertions.assertThat(updatedBox.getColor()).isEqualTo(1111);
    }

    @Test
    public void testDelete(){
        Integer boxId = 2;
        repo.deleteById(boxId);

        Optional<Box> optionalBox = repo.findById(boxId);
        Assertions.assertThat(optionalBox).isNotPresent();
    }
}
