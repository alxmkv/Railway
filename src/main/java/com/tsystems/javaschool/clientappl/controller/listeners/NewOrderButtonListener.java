package com.tsystems.javaschool.clientappl.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tsystems.javaschool.clientappl.views.ClientApplView;

/**
 * Shows new order form on click
 * 
 * @author Alexander Markov
 */
public class NewOrderButtonListener implements ActionListener {

	private final ClientApplView clientApplView;

	/**
	 * @param navigationView
	 */
	public NewOrderButtonListener(ClientApplView clientApplView) {
		this.clientApplView = clientApplView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clientApplView.getNavigationView()
				.getNewOrderButton()) {
			clientApplView.getEditorView().showView("New order", null);
		}
	}
}