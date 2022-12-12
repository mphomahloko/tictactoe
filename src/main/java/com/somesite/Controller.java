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
    final String move = jButton.getName();
    moves.put(move, g_PlayerTurn);
    if (g_numberOfMoves > 4)
    {
      final JButton[][] map = Controller.view.getMap();
      final String[] pos = move.split("\\."); // split name to obtain row and col in map
      int selectedRow = Integer.parseInt(pos[0]), selectedColumn = Integer.parseInt(pos[1]);

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
