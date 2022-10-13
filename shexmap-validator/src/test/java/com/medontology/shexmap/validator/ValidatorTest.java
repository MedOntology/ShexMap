package com.medontology.shexmap.validator;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void shexTest_1iri_pass() {
        assertTrue(Validator.validateSchema(
                new Validator.Load("1iri.shex", "http://a.example/", "S1"),
                new Validator.Load("Is1_Ip1_Io1.ttl", "http://a.example/", "s1")
        ).conforms());
    }

    @Test
    public void shexTest_1iri_fail() {
        assertFalse(Validator.validateSchema(
                new Validator.Load("1iri.shex", "http://a.example/", "S1"),
                new Validator.Load("Is1_Ip1_Io1.ttl", "http://a.example/", "s999")
        ).conforms());
    }

    @Test
    public void bpDAMexample() {
        assertTrue(Validator.validateSchema(
                new Validator.Load("shexmap_example1.shex", "http://dam.example/", "PatientDAM"),
                new Validator.Load("shexmap_data_example1.ttl", "http://dam.example/data/", "PatientX")
        ).conforms());
    }
}
