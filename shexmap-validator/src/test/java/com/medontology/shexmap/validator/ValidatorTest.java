package com.medontology.shexmap.validator;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void test() {
        Validator validator = new Validator();
        assertTrue(validator.validateSchema(
                new Validator.Load("Is1_Ip1_Io1.ttl", "http://a.example/", "s1"),
                new Validator.Load("1iri.shex", "http://a.example/", "S1")
        ));
    }

    @Test
    public void test2() {
        Validator validator = new Validator();
        assertTrue(validator.validateSchema(
                new Validator.Load("shexmap_data_example1.ttl", "http://dam.example/data/", "PatientX"),
                new Validator.Load("shexmap_example1.shex", "http://dam.example/", "PatientDAM")
        ));
    }

}
