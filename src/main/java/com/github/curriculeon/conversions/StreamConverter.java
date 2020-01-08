package com.github.curriculeon.conversions;

import com.github.curriculeon.anthropoid.Person;
import com.github.curriculeon.anthropoid.PersonFactory;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public final class StreamConverter extends PersonConversionAgent<Stream<Person>> {
    private final List<Person> personList;
    public StreamConverter(Stream<Person> people) {
        super(people);
        this.personList = super.objectSequence.collect(Collectors.toList());
    }

    public StreamConverter(int collectionSize) {
        this(Stream
                .generate(new PersonFactory()::createRandomPerson)
                .limit(collectionSize));
    }

    private Supplier<Stream<Person>> streamSupplier = ()-> super.objectSequence;

    // TODO
    public List<Person> toList() {
        return streamSupplier.get().collect(Collectors.toList());
    }

    // TODO
    public Stream<Person> toStream() {
        return streamSupplier.get();
    }

    // TODO
    public Person[] toArray() {
        return streamSupplier.get().toArray((size)-> new Person[size]);
    }
}
