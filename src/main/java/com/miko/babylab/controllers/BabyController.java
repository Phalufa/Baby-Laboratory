package com.miko.babylab.controllers;

import com.miko.babylab.models.Baby;
import com.miko.babylab.services.BabyService;
import com.miko.babylab.services.exceptions.BabyAlreadyExistsException;
import com.miko.babylab.services.exceptions.BabyDoesntExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author Gal
 */
@RestController
@RequestMapping("/babies")
@CrossOrigin(value = {"http://localhost:4200"})
public class BabyController {

    private final BabyService service;

    public BabyController(BabyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> addBaby(@RequestBody Baby baby) throws BabyAlreadyExistsException {
        service.addBaby(baby);
        return ResponseEntity.ok(baby);
    }

    @GetMapping
    public ResponseEntity<?> getBabies() throws BabyDoesntExistsException {
        return ResponseEntity.ok(service.getAllBabies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBaby(@PathVariable long id) throws BabyDoesntExistsException {
        return ResponseEntity.ok(service.getBaby(id));
    }

    @PutMapping
    public ResponseEntity<?> updateBaby(@RequestBody Baby baby) throws BabyDoesntExistsException {
        service.updateBaby(baby);
        return ResponseEntity.ok(baby);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBaby(@PathVariable long id) throws BabyDoesntExistsException {
        service.deleteBaby(id);
        return ResponseEntity.ok("Baby with the ID: " + id + ", has been deleted successfully");
    }

    @GetMapping("/name/{first}/{last}")
    public ResponseEntity<?> getBabiesByFullName(@PathVariable String first,
                                                 @PathVariable String last) throws BabyDoesntExistsException {
        return ResponseEntity.ok(service.getAllBabiesByFirstNameAndLastName(first, last));
    }

    @GetMapping("/name/first/{first}")
    public ResponseEntity<?> getBabiesByFirstName(@PathVariable String first) throws BabyDoesntExistsException {
        return ResponseEntity.ok(service.getAllBabiesByFirstName(first));
    }

    @GetMapping("/name/last/{last}")
    public ResponseEntity<?> getBabiesByLastName(@PathVariable String last) throws BabyDoesntExistsException {
        return ResponseEntity.ok(service.getAllBabiesByLastName(last));
    }

    @GetMapping("/eyes/{color}")
    public ResponseEntity<?> getBabiesByEyeColor(@PathVariable String color) throws BabyDoesntExistsException {
        return ResponseEntity.ok(service.getAllBabiesByEyeColor(color));
    }

    @GetMapping("/skin/{color}")
    public ResponseEntity<?> getBabiesBySkinColor(@PathVariable String color) throws BabyDoesntExistsException {
        return ResponseEntity.ok(service.getAllBabiesBySkinColor(color));
    }

    @GetMapping("/body/{skinColor}/{eyeColor}")
    public ResponseEntity<?> getBabiesBySkinColorAndEyeColor(
                                        @PathVariable String skinColor,
                                        @PathVariable String eyeColor) throws BabyDoesntExistsException {
        List<Baby> allBabiesBySkinColorAndEyeColor = service.getAllBabiesBySkinColorAndEyeColor(skinColor, eyeColor);
        return ResponseEntity.ok(allBabiesBySkinColorAndEyeColor);
    }
}
