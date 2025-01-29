package com.example.mobileappws.shared;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Component;

import static org.apache.commons.text.CharacterPredicates.DIGITS;
import static org.apache.commons.text.CharacterPredicates.LETTERS;


@Component
public class Utils {

    public String generateRandomString(int length) {
        RandomStringGenerator randomStringGenerator = RandomStringGenerator.builder()
                .withinRange('0', 'z')
                .filteredBy(LETTERS, DIGITS)
                .build();
        return randomStringGenerator.generate(length);
    }
}
