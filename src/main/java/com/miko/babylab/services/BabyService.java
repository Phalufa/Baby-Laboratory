package com.miko.babylab.services;

import com.miko.babylab.models.Baby;
import com.miko.babylab.repositories.BabyRepository;
import com.miko.babylab.services.exceptions.BabyAlreadyExistsException;
import com.miko.babylab.services.exceptions.BabyDoesntExistsException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CRUD baby service using baby repository
 * @author Gal
 */
@Service
@Scope("prototype")
public class BabyService {

    private final BabyRepository babyRepo;

    public BabyService(BabyRepository babyRepo) {
        this.babyRepo = babyRepo;
    }

    /**
     *
     * @param baby the baby to create
     * @throws BabyAlreadyExistsException if a baby already exists by its ID
     */
    public void addBaby(Baby baby) throws BabyAlreadyExistsException {
        if (babyRepo.existsById(baby.getId()))
            throw new BabyAlreadyExistsException();

        babyRepo.save(baby);
    }

    /**
     *
     * @param baby the baby to update
     * @throws BabyDoesntExistsException if the baby does not exists by its ID
     */
    public void updateBaby(Baby baby) throws BabyDoesntExistsException {
        if (!babyRepo.existsById(baby.getId()))
            throw new BabyDoesntExistsException();

        babyRepo.save(baby);
    }

    /**
     *
     * @param id the baby's ID
     * @throws BabyDoesntExistsException if the ID is not found
     */
    public void deleteBaby(long id) throws BabyDoesntExistsException {
        if (!babyRepo.existsById(id))
            throw new BabyDoesntExistsException();

        babyRepo.deleteById(id);
    }

    /**
     *
     * @param id the baby's ID
     * @return a baby by the given ID
     * @throws BabyDoesntExistsException if the ID is not found
     */
    public Baby getBaby(long id) throws BabyDoesntExistsException {
        return babyRepo.findById(id).orElseThrow(BabyDoesntExistsException::new);
    }

    /**
     *
     * @return a list of all the babies
     * @throws BabyDoesntExistsException if there are no babies found
     */
    public List<Baby> getAllBabies() throws BabyDoesntExistsException {
        List<Baby> babies = babyRepo.findAll();
        if (babies.size() < 1)
            throw new BabyDoesntExistsException();

        return babies;
    }

    /**
     *
     * @param firstName the babies first names to find
     * @return the babies with the fist name that is given
     * @throws BabyDoesntExistsException if no babies found with the given first name
     */
    public List<Baby> getAllBabiesByFirstName(String firstName) throws BabyDoesntExistsException {
        List<Baby> babies = babyRepo.findByFirstName(firstName);
        if (babies.size() < 1)
            throw new BabyDoesntExistsException();

        return babies;
    }

    /**
     *
     * @param lastName the babies last names to find
     * @return the babies with the last name that is given
     * @throws BabyDoesntExistsException if no babies found with the given last name
     */
    public List<Baby> getAllBabiesByLastName(String lastName) throws BabyDoesntExistsException {
        List<Baby> babies = babyRepo.findByLastName(lastName);
        if (babies.size() < 1)
            throw new BabyDoesntExistsException();

        return babies;
    }

    /**
     *
     * @param firstName the babies first name
     * @param lastName the babies last name
     * @return all the babies that have the given first and last name
     * @throws BabyDoesntExistsException if no babies found with the given first and last name
     */
    public List<Baby> getAllBabiesByFirstNameAndLastName(String firstName, String lastName) throws BabyDoesntExistsException {
        List<Baby> babies = babyRepo.findByFirstNameAndLastName(firstName, lastName);
        if (babies.size() < 1)
            throw new BabyDoesntExistsException();

        return babies;
    }

    /**
     *
     * @param color the babies skin's color
     * @return all the babies with the given skin color
     * @throws BabyDoesntExistsException if no babies found with the given skin color
     */
    public List<Baby> getAllBabiesBySkinColor(String color) throws BabyDoesntExistsException {
        List<Baby> babies = babyRepo.findBySkinColor(color);
        if (babies.size() < 1)
            throw new BabyDoesntExistsException();

        return babies;
    }

    /**
     *
     * @param color the babies eyes color
     * @return all the babies with the given eye color
     * @throws BabyDoesntExistsException if no babies found with the given eye color
     */
    public List<Baby> getAllBabiesByEyeColor(String color) throws BabyDoesntExistsException {
        List<Baby> babies = babyRepo.findByEyeColor(color);
        if (babies.size() < 1)
            throw new BabyDoesntExistsException();

        return babies;
    }

    /**
     *
     * @param skinColor the babies skin's color
     * @param eyeColor the babies eyes color
     * @return all the babies that match the given skin and eye colors criteria
     * @throws BabyDoesntExistsException if no babies match the skin and eye colors criteria
     */
    public List<Baby> getAllBabiesBySkinColorAndEyeColor(String skinColor, String eyeColor) throws BabyDoesntExistsException {
        List<Baby> babies = babyRepo.findBySkinColorAndEyeColor(skinColor, eyeColor);
        if (babies.size() < 1)
            throw new BabyDoesntExistsException();

        return babies;
    }
}
