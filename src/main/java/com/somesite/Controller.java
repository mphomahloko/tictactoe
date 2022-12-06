package com.somesite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller
{
  private static final GUI view = new GUI();
  private static boolean g_ContinueGame = true;
  private static String g_PlayerTurn = "X";
  public Controller()
  {
  }

  public void start()
  {
    view.init();
    view.addPlayerInteraction(new Listener());
  }

  public static void continueGame(final JButton jButton)
  {
    final JButton[][] map = Controller.view.getMap();
    // TODO: determine if game continues from by checking from the last position played
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
      button.removeActionListener(button.getActionListeners()[0]);
      Controller.continueGame(button);
      g_PlayerTurn = "X".equals(g_PlayerTurn) ? "O" : "X";
    }
  }
}
