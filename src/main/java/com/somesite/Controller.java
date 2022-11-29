package com.somesite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller
{
  private final GUI view;
  private static boolean g_ContinueGame = true;
  private static String g_PlayerTurn = "X";
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
      button.setText(g_PlayerTurn);
      g_PlayerTurn = "X".equals(g_PlayerTurn) ? "O" : "X";
      button.removeActionListener(button.getActionListeners()[0]);
    }
  }
}
