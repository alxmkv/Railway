package com.tsystems.javaschool.clientappl.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.tsystems.javaschool.clientappl.ClientSenderReceiver;
import com.tsystems.javaschool.clientappl.views.ClientApplView;
import com.tsystems.javaschool.clientappl.views.ErrorMessageView;
import com.tsystems.javaschool.clientappl.views.NewOrderView;
import com.tsystems.javaschool.common.RequestType;
import com.tsystems.javaschool.common.ServiceRequest;
import com.tsystems.javaschool.common.ServiceResponse;

/**
 * Search for trains
 * 
 * @author Alexander Markov
 */
public class SearchButtonListener implements ActionListener {

	private final ClientApplView clientApplView;

	public SearchButtonListener(ClientApplView clientApplView) {
		this.clientApplView = clientApplView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO: train search with Request
		if (e.getSource() == clientApplView.getEditorView().getNewOrderView()
				.getSearchButton()) {
			NewOrderView newOrderView = clientApplView.getEditorView()
					.getNewOrderView();
			// TODO: input parameters validation
			String from = newOrderView.getFromTextField().getText();
			if ("".equals(from)) {
				new ErrorMessageView(clientApplView.getFrame(),
						"Please, fill at least from field.");
				return;
			}
			List<String> payload = new ArrayList<String>(4);
			payload.add(0, from);
			payload.add(1, newOrderView.getToTextField().getText());
			payload.add(2, newOrderView.getTimeFromTextField().getText());
			payload.add(3, newOrderView.getTimeToTextField().getText());
			ClientSenderReceiver.send(new ServiceRequest(
					RequestType.TRAINSBYSTATIONSANDTIME, payload));
			ServiceResponse response = ClientSenderReceiver.receive();
			if (response != null && response.getStatus()) {
				clientApplView.getEditorView().showView("Search results",
						response.getPayload());
			} else {
				if (response == null) {
					new ErrorMessageView(clientApplView.getFrame(),
							"Please, try again later.");
				} else {
					new ErrorMessageView(clientApplView.getFrame(),
							response.getException());
				}
			}
		}
	}
}