package com.tsystems.javaschool.clientappl.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.tsystems.javaschool.clientappl.views.MenuView;

/**
 * Quits application on exit click
 * 
 * @author Alexander Markov
 */
public class ExitMenuItemListener implements ActionListener {

	private final MenuView menu;

	/**
	 * @param menu
	 */
	public ExitMenuItemListener(MenuView menu) {
		this.menu = menu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menu.getFileExitMenu()) {
			System.exit(0);
		}
	}
}