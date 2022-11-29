package com.somesite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller
{
  private final GUI view;
  private static String state = "X";
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
      if (e.getSource() instanceof JButton)
      {
        this.updateView((JButton) e.getSource());
      }
    }

    public  void  updateView(final JButton button)
    {
      button.setText(state);
      button.removeActionListener(button.getActionListeners()[0]);
      state = "X".equals(state) ? "O" : "X";
    }
  }
}
