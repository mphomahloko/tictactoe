package com.somesite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller
{
  private final GUI view;
  public Controller(final GUI view)
  {
    this.view = view;
  }

  public void start()
  {
    view.init();
    view.addPlayerInteraction(new Listener());
  }

  static class Listener implements ActionListener
  {

    @Override
    public void actionPerformed(ActionEvent e)
    {
      System.out.println(e.getActionCommand());
    }
  }
}
