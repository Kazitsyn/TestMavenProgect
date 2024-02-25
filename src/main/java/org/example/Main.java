package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String FILE_JSON = "src/main/resources/tasks.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();


    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        List<Person> personsRead = new ArrayList<>();
        for (int i = 0; i < 13; i++){
            persons.add(Person.create());
        }
        try {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(FILE_JSON), persons);
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            File file = new File(FILE_JSON);

            personsRead = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Person.class));
        }catch (IOException e){
            e.printStackTrace();
        }
        personsRead.forEach(System.out::println);
    }
}