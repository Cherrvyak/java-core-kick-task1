package com.innowise.ft.validator.impl;

import com.innowise.ft.validator.Validator;

import java.util.regex.Pattern;

class CustomValidatorImpl implements Validator {
  private String stringPatternRegex;

  public CustomValidatorImpl(String stringPatternRegex){
    this.stringPatternRegex = stringPatternRegex;
  }

  @Override
  public boolean isStringValid(String stringToValid) {
    Pattern pattern = Pattern.compile(stringPatternRegex);
    return pattern.matcher(stringToValid).matches();
  }
}


