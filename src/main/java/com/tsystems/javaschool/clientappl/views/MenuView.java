package com.tsystems.javaschool.clientappl.views;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import com.tsystems.javaschool.clientappl.controller.listeners.ExitMenuItemListener;

/**
 * Main menu GUI
 * 
 * @author Alexander Markov
 */
public class MenuView {
	private final int ITEM_PLAIN = 1;
	private final int ITEM_RADIO = 2;
	private final int ITEM_CHECK = 3;
	// Menu elements
	private final JMenuBar menuBar;
	private final JMenu fileMenu;
	private final JMenu helpMenu;
	private final JMenuItem fileExitMenu;

	/**
	 * Constructs application menu bar
	 * 
	 * @param frame
	 */
	public MenuView(ClientApplFrame frame) {
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		getMenuItem(fileMenu, ITEM_PLAIN, "Connect", null, 'C',
				"Connect to server");
		fileExitMenu = getMenuItem(fileMenu, ITEM_PLAIN, "Exit", null, 'X',
				"Quit");
		fileExitMenu.addActionListener(new ExitMenuItemListener(this));
		menuBar.add(fileMenu);
		helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		menuBar.add(helpMenu);
	}

	/**
	 * @param menu
	 * @param itemType
	 * @param sText
	 * @param image
	 * @param acceleratorKey
	 * @param sToolTip
	 * @return New menu item
	 */
	private JMenuItem getMenuItem(JMenu menu, int itemType, String sText,
			ImageIcon image, int acceleratorKey, String sToolTip) {
		// Create the item
		JMenuItem menuItem;
		switch (itemType) {
		case ITEM_RADIO:
			menuItem = new JRadioButtonMenuItem();
			break;
		case ITEM_CHECK:
			menuItem = new JCheckBoxMenuItem();
			break;
		default:
			menuItem = new JMenuItem();
			break;
		}
		// Add the item text and font
		menuItem.setText(sText);
		// menuItem.setFont(applicationView.getFont());
		// Add the optional icon
		if (image != null)
			menuItem.setIcon(image);
		// Add the accelerator key
		if (acceleratorKey > 0)
			menuItem.setMnemonic(acceleratorKey);
		// Add the optional tool tip text
		if (sToolTip != null)
			menuItem.setToolTipText(sToolTip);
		// Add an action handler to this menu item
		// menuItem.addActionListener(this);
		menu.add(menuItem);
		return menuItem;
	}

	/**
	 * @return Exit menu item
	 */
	public JMenuItem getFileExitMenu() {
		return fileExitMenu;
	}
}