package com.miko.babylab.models;

import javax.persistence.*;
import java.util.Objects;

/**
 * Represents a baby
 * Whether a baby is normal or abnormal is up to you
 * @author Gal
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "babies")
public class Baby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Gender gender;
    @Column
    private String skinColor;
    @Column
    private String hairColor;
    @Column
    private String eyeColor;
    @Column
    private int numOfLegs;
    @Column
    private int numOfFingersInEachLeg;
    @Column
    private int numOfHands;
    @Column
    private int numOfFingersInEachHand;

    public Baby() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyesColor) {
        this.eyeColor = eyesColor;
    }

    public int getNumOfLegs() {
        return numOfLegs;
    }

    public void setNumOfLegs(int numOflegs) {
        this.numOfLegs = numOflegs;
    }

    public int getNumOfFingersInEachLeg() {
        return numOfFingersInEachLeg;
    }

    public void setNumOfFingersInEachLeg(int numOfLegsFingers) {
        this.numOfFingersInEachLeg = numOfLegsFingers;
    }

    public int getNumOfHands() {
        return numOfHands;
    }

    public void setNumOfHands(int numOfhands) {
        this.numOfHands = numOfhands;
    }

    public int getNumOfFingersInEachHand() {
        return numOfFingersInEachHand;
    }

    public void setNumOfFingersInEachHand(int numOfhandsFingers) {
        this.numOfFingersInEachHand = numOfhandsFingers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baby baby = (Baby) o;
        return id == baby.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }
}
