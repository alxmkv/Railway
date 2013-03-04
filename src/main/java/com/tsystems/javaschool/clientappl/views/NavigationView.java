package com.tsystems.javaschool.clientappl.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.tsystems.javaschool.clientappl.controller.listeners.NewOrderButtonListener;

/**
 * View for vertical navigation
 * 
 * @author Alexander Markov
 */
public class NavigationView extends JPanel {

	private static final long serialVersionUID = -6583999992292986844L;
	private final JButton newOrderButton;
	private final JLabel myOrdersLabel;
	private final JLabel timetableLabel;

	/**
	 * Constructs navigation menu
	 * 
	 * @param clientApplView
	 */
	public NavigationView(ClientApplView clientApplView) {
		this.setPreferredSize(new Dimension(clientApplView
				.getActualFrameWidth() / 3, clientApplView
				.getActualFrameHeight()));
		this.setMinimumSize(new Dimension(
				clientApplView.getActualFrameWidth() / 3, clientApplView
						.getActualFrameHeight()));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		this.setLayout(new GridLayout(16, 1));
		newOrderButton = new JButton("New Order");
		newOrderButton.setBackground(Color.lightGray);
		newOrderButton.setPreferredSize(new Dimension(clientApplView
				.getActualFrameWidth() / 3, 20));
		newOrderButton.addActionListener(new NewOrderButtonListener(
				clientApplView));
		myOrdersLabel = new JLabel("My Orders", SwingConstants.CENTER);
		timetableLabel = new JLabel("Timetable", SwingConstants.CENTER);
		this.add(newOrderButton);
		this.add(myOrdersLabel);
		this.add(timetableLabel);
	}

	/**
	 * @return New order button
	 */
	public JButton getNewOrderButton() {
		return newOrderButton;
	}
}