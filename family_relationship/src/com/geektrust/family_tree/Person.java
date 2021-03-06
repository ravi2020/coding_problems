package com.geektrust.family_tree;

import com.geektrust.family_tree.constants.Gender;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Gender gender;
    private Parents parents;
    private List<Person> childrens;
    private Person spouse;

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.childrens = new ArrayList<>();
    }

    public List<Person> getChildrens() {
        return childrens;
    }

    public Person setSpouse(Person spouse) {
        if ((spouse.gender == this.gender) || this.spouse != null) return null;
        this.spouse = spouse;
        spouse.setSpouse(this);
        return this;
    }

    public Person addChild(Person child) {
        childrens.add(child);
        if (spouse != null && !isChildExists(spouse,child)) spouse.addChild(child);
        addSelfAsParentOf(child);
        return this;
    }

    private void addSelfAsParentOf(Person child) {
        if (this.gender == Gender.MALE) {
            child.addParents(this, spouse);
        } else {
            child.addParents(spouse, this);
        }
    }

    public void addParents(Person father, Person mother) {
        this.parents = new Parents(mother, father);
    }


    public Parents getParents() {
        return parents;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public Person getSpouse() {
        return spouse;
    }

    private boolean isChildExists(Person parent,Person child){
        for (Person children : parent.childrens) {
            if (children.equals(child)) return true;
        }
        return false;
    }

}
