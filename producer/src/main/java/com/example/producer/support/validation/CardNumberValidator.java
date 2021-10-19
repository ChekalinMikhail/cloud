package com.example.producer.support.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardNumberValidator implements ConstraintValidator<CardNumber, String> {

  @Override
  public void initialize(CardNumber constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null)
      return false;

    Pattern pattern = Pattern.compile("^[0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}$");
    Matcher matcher = pattern.matcher(value.trim());

    return matcher.matches();
  }
}
