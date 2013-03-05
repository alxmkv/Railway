package com.tsystems.javaschool.clientappl.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import com.tsystems.javaschool.clientappl.controller.listeners.NewOrderButtonListener;

/**
 * View for vertical navigation
 * 
 * @author Alexander Markov
 */
public class NavigationView extends JPanel {

	private static final long serialVersionUID = -6583999992292986844L;
	private final Font navigationViewFont;
	private final JButton newOrderButton;
	private final JButton myOrdersButton;
	private final JButton timetableButton;
	private final JButton addStationTrainButton;
	private final JButton passengersButton;
	private final JButton trainsButton;

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
		navigationViewFont = new Font("Verdana", Font.PLAIN, 24);
		newOrderButton = new JButton("New Order");
		newOrderButton.setBackground(Color.lightGray);
		newOrderButton.setFont(navigationViewFont);
		newOrderButton.setPreferredSize(new Dimension(clientApplView
				.getActualFrameWidth() / 3, 20));
		newOrderButton.addActionListener(new NewOrderButtonListener(
				clientApplView));
		myOrdersButton = new JButton("My Orders");
		myOrdersButton.setBackground(Color.lightGray);
		myOrdersButton.setFont(navigationViewFont);
		myOrdersButton.setPreferredSize(new Dimension(clientApplView
				.getActualFrameWidth() / 3, 20));
		myOrdersButton.addActionListener(new NewOrderButtonListener(
				clientApplView));
		timetableButton = new JButton("Timetable");
		timetableButton.setBackground(Color.lightGray);
		timetableButton.setFont(navigationViewFont);
		timetableButton.setPreferredSize(new Dimension(clientApplView
				.getActualFrameWidth() / 3, 20));
		timetableButton.addActionListener(new NewOrderButtonListener(
				clientApplView));
		addStationTrainButton = new JButton("Add stations/trains");
		addStationTrainButton.setBackground(Color.lightGray);
		addStationTrainButton.setFont(navigationViewFont);
		addStationTrainButton.setPreferredSize(new Dimension(clientApplView
				.getActualFrameWidth() / 3, 20));
		addStationTrainButton.addActionListener(new NewOrderButtonListener(
				clientApplView));
		passengersButton = new JButton("Edit passengers");
		passengersButton.setBackground(Color.lightGray);
		passengersButton.setFont(navigationViewFont);
		passengersButton.setPreferredSize(new Dimension(clientApplView
				.getActualFrameWidth() / 3, 20));
		passengersButton.addActionListener(new NewOrderButtonListener(
				clientApplView));
		trainsButton = new JButton("Add stations/trains");
		trainsButton.setBackground(Color.lightGray);
		trainsButton.setFont(navigationViewFont);
		trainsButton.setPreferredSize(new Dimension(clientApplView
				.getActualFrameWidth() / 3, 20));
		trainsButton.addActionListener(new NewOrderButtonListener(
				clientApplView));
		this.add(newOrderButton);
		this.add(timetableButton);
		this.add(myOrdersButton);
		this.add(addStationTrainButton);
		this.add(passengersButton);
		this.add(trainsButton);
	}

	/**
	 * @return New order button
	 */
	public JButton getNewOrderButton() {
		return newOrderButton;
	}

	/**
	 * @return My Orders button
	 */
	public JButton getMyOrdersButton() {
		return myOrdersButton;
	}

	/**
	 * @return Timetable button
	 */
	public JButton getTimetableButton() {
		return timetableButton;
	}

	/**
	 * @return Add station/train button
	 */
	public JButton getAddStationTrainButton() {
		return addStationTrainButton;
	}

	/**
	 * @return Passengers button
	 */
	public JButton getPassengersButton() {
		return passengersButton;
	}

	/**
	 * @return Trains button
	 */
	public JButton getTrainsButton() {
		return trainsButton;
	}
}