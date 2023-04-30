package com.myshop.shop.common.jpa;

import com.myshop.shop.common.model.Email;
import com.myshop.shop.common.model.EmailSet;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.Set;


import static java.util.stream.Collectors.*;

public class EmailSetConverter implements AttributeConverter<EmailSet, String> {

    @Override
    public String convertToDatabaseColumn(EmailSet attribute) {
        if (attribute == null) return null;
        return attribute.getEmails().stream()
                .map(Email::getAddress)
                .collect(joining(","));
    }

    @Override
    public EmailSet convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        String[] emails = dbData.split(",");
        Set<Email> emailSet = Arrays.stream(emails)
                .map(Email::new)
                .collect(toSet());
        return new EmailSet(emailSet);
    }
}
