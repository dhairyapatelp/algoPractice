package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private class Person{
        Person parent1;
        Person parent2;
        String name;
        List<String> children = null;

        public Person(){}
        public Person(Person parent1, Person parent2, String name){
            children = new ArrayList<>();
            this.parent1 = parent1;
            this.parent2 = parent2;
            this.name = name;
        }
    }

    public static void main(String[] args){

    }
}
