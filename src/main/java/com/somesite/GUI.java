package com.somesite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame
{
  JPanel view;

  final JButton a1 = new JButton();
  final JButton a2 = new JButton();
  final JButton a3 = new JButton();


  final JButton b1 = new JButton();
  final JButton b2 = new JButton();
  final JButton b3 = new JButton();


  final JButton c1 = new JButton();
  final JButton c2 = new JButton();
  final JButton c3 = new JButton();
  public GUI()
  {
    super("Tic Tac Toe");
  }

  public void init()
  {
    view = new JPanel();

    view.setLayout(new GridLayout(3, 3));
    view.add(a1);
    view.add(a2);
    view.add(a3);

    view.add(b1);
    view.add(b2);
    view.add(b3);

    view.add(c1);
    view.add(c2);
    view.add(c3);

    this.add(view);
    this.setSize(300, 300);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void  addPlayerInteraction(final ActionListener listener)
  {
    a1.addActionListener(listener);
    a2.addActionListener(listener);
    a3.addActionListener(listener);

    b1.addActionListener(listener);
    b2.addActionListener(listener);
    b3.addActionListener(listener);

    c1.addActionListener(listener);
    c2.addActionListener(listener);
    c3.addActionListener(listener);
  }
}