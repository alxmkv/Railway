package com.tsystems.javaschool.clientappl.views;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 * Main GUI for client application
 * 
 * @author Alexander Markov
 */
public class ClientApplView {

	private final ClientApplFrame frame;
	private final String frameTitle = "Railway Information System";
	private final int frameWidth = 1024;
	private final int frameHeight = 768;
	private final JPanel framePanel;
	private final CardLayout framePanelLayout;
	private final int framePanelLayoutHGap = 120;
	private final int framePanelLayoutVGap = 120;
	private final JSplitPane frameSplitPaneH;
	private final LoginView loginView;
	private final RegistrationView registrationView;
	private final NavigationView navigationView;
	private final EditorView editorView;

	/**
	 * Constructs client GUI
	 * 
	 * @param clientApplFrame
	 */
	public ClientApplView(ClientApplFrame clientApplFrame) {
		this.frame = clientApplFrame;
		// 1. Set parameters
		frame.setTitle(frameTitle);
		frame.setSize(frameWidth, frameHeight);
		frame.setResizable(true);
		frame.setBackground(Color.white);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 2. Create panel for content
		framePanel = new JPanel();
		framePanelLayout = new CardLayout(framePanelLayoutHGap,
				framePanelLayoutVGap);
		framePanel.setLayout(framePanelLayout);
		framePanel.setBackground(Color.white);
		framePanel.setDoubleBuffered(true);
		frame.getContentPane().add(framePanel);
		new MenuView(frame);
		loginView = new LoginView(this);
		registrationView = new RegistrationView(this);
		navigationView = new NavigationView(this);
		editorView = new EditorView(this);
		// 4. Create home page split pane
		frameSplitPaneH = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		frameSplitPaneH.setResizeWeight(0);
		frameSplitPaneH.setBackground(Color.white);
		frameSplitPaneH.setDoubleBuffered(true);
		frameSplitPaneH.setLeftComponent(navigationView);
		frameSplitPaneH.setRightComponent(editorView);
		// 5. Add views to card layout
		framePanel.add(loginView, "Login");
		framePanel.add(registrationView, "Registration");
		framePanel.add(frameSplitPaneH, "Home");
		showView("Login");
	}

	/**
	 * @param view
	 *            name of view to show
	 */
	public void showView(String view) {
		if ("Login".equalsIgnoreCase(view)
				|| "Registration".equalsIgnoreCase(view)) {
			framePanelLayout.setHgap(framePanelLayoutHGap);
			framePanelLayout.setVgap(framePanelLayoutVGap);
		} else {
			framePanelLayout.setHgap(framePanelLayoutHGap / 10);
			framePanelLayout.setVgap(framePanelLayoutVGap / 10);
		}
		framePanelLayout.show(framePanel, view);
	}

	/**
	 * @return GUI frame
	 */
	public ClientApplFrame getFrame() {
		return frame;
	}

	/**
	 * @return Login form
	 */
	public LoginView getLoginView() {
		return loginView;
	}

	/**
	 * @return Registration form
	 */
	public RegistrationView getRegistrationView() {
		return registrationView;
	}

	/**
	 * @return Navigation
	 */
	public NavigationView getNavigationView() {
		return navigationView;
	}

	/**
	 * @return Editor
	 */
	public EditorView getEditorView() {
		return editorView;
	}

	/**
	 * @return Current width of client window
	 */
	public int getActualFrameWidth() {
		return frame.getWidth();
	}

	/**
	 * @return Current height of client window
	 */
	public int getActualFrameHeight() {
		return frame.getHeight();
	}
}