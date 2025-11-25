package com.innowise.ft.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Validator {
  public interface CustomValidator {
    public boolean isStringValid(String stringToValid);
  }
}
