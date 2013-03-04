/**
 * 
 */
package com.tsystems.javaschool.clientappl.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.tsystems.javaschool.clientappl.controller.listeners.SearchButtonListener;

/**
 * View for a new ticket order
 * 
 * @author Alexander Markov
 */
public class NewOrderView extends JPanel {

	private static final long serialVersionUID = 1433342346122196759L;

	private final Font newOrderViewFont;
	private final JButton searchButton;
	private final JLabel fromLabel;
	private final JLabel toLabel;
	private final JLabel timeFromLabel;
	private final JLabel timeToLabel;
	private final JTextField fromTextField;
	private final JTextField toTextField;
	private final JTextField timeFromTextField;
	private final JTextField timeToTextField;

	public NewOrderView(ClientApplView clientApplView) {
		this.setLayout(new GridLayout(9, 2, 10, 10));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		newOrderViewFont = new Font("Verdana", Font.PLAIN, 24);
		searchButton = new JButton("Search");
		searchButton.setBackground(Color.lightGray);
		searchButton.setFont(newOrderViewFont);
		searchButton
				.addActionListener(new SearchButtonListener(clientApplView));
		fromLabel = new JLabel("From:");
		fromLabel.setFont(newOrderViewFont);
		toLabel = new JLabel("To:");
		toLabel.setFont(newOrderViewFont);
		timeFromLabel = new JLabel("Time from:");
		timeFromLabel.setFont(newOrderViewFont);
		timeToLabel = new JLabel("Time to:");
		timeToLabel.setFont(newOrderViewFont);
		fromTextField = new JTextField();
		fromTextField.setFont(newOrderViewFont);
		toTextField = new JTextField();
		toTextField.setFont(newOrderViewFont);
		timeFromTextField = new JTextField();
		timeFromTextField.setFont(newOrderViewFont);
		timeToTextField = new JTextField();
		timeToTextField.setFont(newOrderViewFont);
		this.add(fromLabel);
		this.add(fromTextField);
		this.add(toLabel);
		this.add(toTextField);
		this.add(timeFromLabel);
		this.add(timeFromTextField);
		this.add(timeToLabel);
		this.add(timeToTextField);
		this.add(new JLabel(""));
		this.add(searchButton);
	}

	/**
	 * @return Search button
	 */
	public JButton getSearchButton() {
		return searchButton;
	}

	/**
	 * @return Departure
	 */
	public JTextField getFromTextField() {
		return fromTextField;
	}

	/**
	 * @return Destination
	 */
	public JTextField getToTextField() {
		return toTextField;
	}

	/**
	 * @return Time from
	 */
	public JTextField getTimeFromTextField() {
		return timeFromTextField;
	}

	/**
	 * @return Time to
	 */
	public JTextField getTimeToTextField() {
		return timeToTextField;
	}
}