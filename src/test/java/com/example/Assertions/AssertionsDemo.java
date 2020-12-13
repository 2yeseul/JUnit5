package com.example.Assertions;

import com.example.junit5test.Cal.Calculator;
import com.example.junit5test.Person.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsDemo {
    private final Calculator calculator = new Calculator();
    private final Person person = new Person("Jane" , "Doe");

    @Test
    @DisplayName("Calculator Test")
    void standrdAssertions() {
        assertEquals(2, calculator.add(1, 1));
        assertEquals(6, calculator.multiply(3, 2) ,
                "The optional failure message is now the last parameter");
        assertTrue('a' < 'b', () -> "Assertion messages can be lazily evaluated --" +
                "to avoid constructing complex messages unnecessarily.");
    }

    @Test
    @DisplayName("Person Test - group")
    void groupAssertions() {
        assertAll("person",
                () -> assertEquals("Jane", person.getFirstName()),
                () -> assertEquals("Doe", person.getLastName())
        );
    }

    @Test
    @DisplayName("Person Test - dependent")
    void dependentAssertions() {
        assertAll("properties",
                () -> {
                    String firstName = person.getFirstName();
                    assertNotNull(firstName);
                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("J")),
                            () -> assertTrue(firstName.endsWith("e"))
                    );
                },
                () -> {
                    String lastName = person.getLastName();
                    assertNotNull(lastName);
                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("D")),
                            () -> assertTrue(lastName.endsWith("e"))
                    );
                }
        );
    }
    @Test
    void createNewPerson(){
        Person person1 = Person.builder()
                .firstName("Seul")
                .build();
        assertNotNull(person1);
        assertEquals("Seul", person1.getFirstName());
    }
}
