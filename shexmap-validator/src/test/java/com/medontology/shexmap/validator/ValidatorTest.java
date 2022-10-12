package com.medontology.shexmap.validator;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void test() {
        Validator validator = new Validator();
        assertTrue(validator.validateSchema("http://a.example", "Is1_Ip1_Io1.ttl", "http://a.example/s1", "1iri.shex", "http://a.example", "http://a.example/S1"));
    }

    @Test
    public void test2() {
        Validator validator = new Validator();
        assertTrue(validator.validateSchema("http://dam.example/data/", "shexmap_data_example1.ttl", "http://dam.example/data/PatientX", "shexmap_example1.shex", "http://dam.example/med", "http://dam.example/PatientDAM"));
    }

}
