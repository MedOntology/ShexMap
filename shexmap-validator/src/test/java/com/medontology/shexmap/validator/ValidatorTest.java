package com.medontology.shexmap.validator;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void test() {
        Validator validator = new Validator();
        assertTrue(validator.validateSchema("1iri.shex", "http://a.example", "Is1_Ip1_Io1.ttl", "http://a.example/s1", "http://a.example/S1"));
    }

    @Test
    public void test2() {
        Validator validator = new Validator();
        assertTrue(validator.validateSchema("shexmap_example1.shex", "http://dam.example/med", "shexmap_data_example1.ttl", "http://dam.example/data/PatientX", "http://dam.example/PatientDAM"));
    }

}
