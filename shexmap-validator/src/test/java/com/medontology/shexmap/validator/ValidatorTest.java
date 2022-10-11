package com.medontology.shexmap.validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void test() {
        Validator validator = new Validator();
        validator.loadExample("1iri.shex");
    }

}
