package com.miko.babylab.repositories;

import com.miko.babylab.models.Baby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BabyRepository extends JpaRepository<Baby, Long> {

    List<Baby> findByFirstName(String firstName);
    List<Baby> findByLastName(String lastName);
    List<Baby> findByFirstNameAndLastName(String firstName, String lastName);

    List<Baby> findByEyeColor(String color);
    List<Baby> findBySkinColor(String color);
    List<Baby> findBySkinColorAndEyeColor(String skinColor, String eyeColor);

}
