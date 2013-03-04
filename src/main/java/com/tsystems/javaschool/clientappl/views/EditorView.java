package com.tsystems.javaschool.clientappl.views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * View for forms, tables and other content
 * 
 * @author Alexander Markov
 */
public class EditorView extends JScrollPane {

	private static final long serialVersionUID = 6180786315815138488L;
	private final JPanel editorPanel;
	private final CardLayout editorPanelLayout;
	private final NewOrderView newOrderView;

	/**
	 * Constructs editor view
	 * 
	 * @param clientApplView
	 */
	public EditorView(ClientApplView clientApplView) {
		this.setPreferredSize(new Dimension(2 * clientApplView
				.getActualFrameWidth() / 3, clientApplView
				.getActualFrameHeight()));
		this.setMinimumSize(new Dimension(2 * clientApplView
				.getActualFrameWidth() / 3, clientApplView
				.getActualFrameHeight()));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		editorPanel = new JPanel();
		editorPanelLayout = new CardLayout();
		editorPanel.setLayout(editorPanelLayout);
		newOrderView = new NewOrderView(clientApplView);
		editorPanel.add(newOrderView, "New order");
		this.getViewport().add(editorPanel);
	}

	/**
	 * @param view
	 *            name of view to show
	 */
	public void showView(String view) {
		editorPanelLayout.show(editorPanel, view);
	}

	/**
	 * @return New order form
	 */
	public NewOrderView getNewOrderView() {
		return newOrderView;
	}
}