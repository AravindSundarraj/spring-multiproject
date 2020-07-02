/*
package com.group.apartment.apartment.repo;

import com.group.apartment.apartment.model.id.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ApartmentRepo {

    @Autowired
    EntityManager entityManager;
    private static final int BATCH_SIZE = 2;

    @Transactional
    public void addApartment(Apartment apartment){

        entityManager.persist(apartment);

    }

    @Transactional
    public void addApartmentInBatch(List<Apartment> apartmentList){

        int count = 0;
        for(int i = 0; i < apartmentList.size(); i++){
            if (i > 0 && i % BATCH_SIZE == 0) {
                entityManager.flush();
                entityManager.clear();
            }
            entityManager.persist(apartmentList.get(i));

        }

    }

}
*/
