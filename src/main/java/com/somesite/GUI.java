package com.somesite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame
{
  final JPanel view;
  final JButton[][] map = new JButton[3][3];


  public GUI()
  {
    super("Tic Tac Toe");
    this.view = new JPanel();
    for (int rw = 0; rw < 3; rw+=1)
    {
      for (int col = 0; col < 3; col+=1)
      {
        this.map[rw][col] = new JButton();
      }
    }
  }


  public void init()
  {

    this.view.setLayout(new GridLayout(3, 3));
    for (int rw = 0; rw < 3; rw+=1)
    {
      for (int col = 0; col < 3; col+=1)
      {
        this.view.add(this.map[rw][col]);
        this.map[rw][col].setName(rw+"."+col);
      }
    }


    this.add(this.view);
    this.setSize(300, 300);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }


  public JButton[][] getMap()
  {
    return this.map;
  }


  public void  addPlayerInteraction(final ActionListener listener)
  {
    for (int rw = 0; rw < 3; rw+=1)
    {
      for (int col = 0; col < 3; col+=1)
      {
        this.map[rw][col].addActionListener(listener);
      }
    }
  }
}
