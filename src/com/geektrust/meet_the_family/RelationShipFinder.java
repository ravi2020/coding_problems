package com.geektrust.meet_the_family;



import com.geektrust.meet_the_family.relations.Relation;

import java.util.ArrayList;
import java.util.List;

public class RelationShipFinder {

    public List<String> find(Person person, Relation relation) {
        List<Person> relatives = relation.getAll(person);
        List<String> relativesNames = new ArrayList<>();
        for (Person relative : relatives) {
            relativesNames.add(relative.getName());
        }
        return relativesNames;
    }
}
