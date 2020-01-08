package com.github.curriculeon;

import com.github.curriculeon.anthropoid.Person;
import com.github.curriculeon.anthropoid.PersonFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by leon on 5/2/17.
 */
public class StreamFilter {
    private final Stream<Person> personStream;
    public final String startingCharacter;

    /**
     * No arg constructor
     */ //TODO - construct person stream of 100 person objects; startingCharacter is a random capital letter
    public StreamFilter() {
//        List<Character> capitalLetters = new ArrayList<>();
//        for(int i=65; i<=90; i++){
//            capitalLetters.add(Character.toChars(i)[0]);
//        }
//        Random randomNumberGenerator = new Random();
//        int randomNumber = randomNumberGenerator.nextInt(26);
        this(new PersonFactory().createPersonStream(100)
                , Character.toChars(new Random().nextInt(26) + 65)[0]);
    }

    /**
     * @param people            - Array of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(Person[] people, Character startingCharacter) {
        this(Arrays.stream(people), startingCharacter);
    }

    /**
     * @param people            - List of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(List<Person> people, Character startingCharacter) {
        this(people.stream(), startingCharacter);
    }


    /**
     * @param people            - Stream of person objects
     * @param startingCharacter - character to filter by
     */ // I took care of the easy constructor (͡° ͜ʖ ͡°)
    public StreamFilter(Stream<Person> people, Character startingCharacter) {
        this.personStream = people;
        this.startingCharacter = startingCharacter.toString();
    }


    /**
     * Using multi-line lambda syntax
     *
     * @return a list of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListMultiLine() {
        return personStream.filter(p -> p.getName().startsWith(startingCharacter)).collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     *
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListOneLine() {
        return personStream.filter(p -> p.getName().startsWith(startingCharacter)).collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     *
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayOneLine() {
        return personStream.filter(p -> p.getName().startsWith(startingCharacter)).toArray(Person[]::new);
    }


    /**
     * Using multi-line lambda syntax
     *
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayMultiLine() {
        return personStream.filter(p -> p.getName().startsWith(startingCharacter)).toArray(Person[]::new);

    }

}
