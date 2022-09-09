package io.ansan.sistemaexamenes.exceptions;

public class UserFoundException extends Exception{
  public UserFoundException() {
    super("The user with that username already exists");
  }

  public UserFoundException(String message) {
    super(message);
  }
}
