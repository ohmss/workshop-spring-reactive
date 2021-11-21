package com.datastax.workshop.petclinic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.datastax.workshop.petclinic.reflist.ReferenceListReactiveDao;

@SpringBootTest
public class Test05_ReactiveController {
    
    @Autowired
    ReferenceListReactiveDao referenceListDao;
    
    @Test
    public void should_list_vet_specialies() {
        System.out.println(referenceListDao.findReferenceList("vet_specialty").block());
    }

}
