package com.somesite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Controller
{
  private static final GUI view = new GUI();
  private static int g_numberOfMoves = 0;
  private static Map<String, String> moves;
  private static boolean g_ContinueGame = true;
  private static String g_PlayerTurn = "X";


  public Controller()
  {
    moves = new HashMap<>();
  }


  public void start()
  {
    view.init();
    view.addPlayerInteraction(new Listener());
  }


  public static void continueGame(final JButton jButton)
  {
    if (moves.containsKey(g_PlayerTurn))
    {
      moves.put(g_PlayerTurn, moves.get(g_PlayerTurn)+"|"+jButton.getName());
    }
    else
    {
      moves.put(g_PlayerTurn, jButton.getName());
    }
    if (++g_numberOfMoves > 4)
    {
      for(final String move : moves.values())
      {
        System.out.println(move);
      }
    }
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
      Controller.continueGame(button);
      g_PlayerTurn = "X".equals(g_PlayerTurn) ? "O" : "X";
      button.removeActionListener(button.getActionListeners()[0]);
    }
  }
}
