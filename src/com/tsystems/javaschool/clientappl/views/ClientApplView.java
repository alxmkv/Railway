package com.tsystems.javaschool.clientappl.views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Main GUI for client application
 * @author Alexander Markov
 */
public class ClientApplView {
	
	private final ClientApplFrame frame;
	private final String frameTitle = "Railway Information System";
	private final int frameWidth = 1024;
	private final int frameHeight = 768;
	private final JPanel framePanel;

	public ClientApplView(ClientApplFrame clientApplFrame) {
		this.frame = clientApplFrame;
		// 1. Set parameters
		frame.setTitle(frameTitle);
		frame.setSize(frameWidth, frameHeight);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 2. Create panel for content
		framePanel = new JPanel();		
		framePanel.setLayout(new BorderLayout());
		frame.getContentPane().add(framePanel);
		framePanel.setBackground(Color.white);
		// 3. Create menu
		new MenuView(frame);
	}
}