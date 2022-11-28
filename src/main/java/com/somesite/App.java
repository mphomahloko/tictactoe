package com.somesite;

public class App
{
  public static void main(String... args)
  {
    final Controller controller = new Controller(new GUI());

    controller.start();
  }
}
