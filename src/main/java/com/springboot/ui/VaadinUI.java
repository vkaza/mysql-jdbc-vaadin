package com.springboot.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.model.RaymondJamesInterview;
import com.springboot.service.InterviewService;
import com.springboot.util.FormUtil;
import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
public class VaadinUI extends UI {

	@Autowired
	private InterviewService service;

	@Autowired
	private FormUtil formUtil;

	private RaymondJamesInterview raymondJamesInterview;

	private Binder<RaymondJamesInterview> binder = new Binder<>(RaymondJamesInterview.class);

	private Grid<RaymondJamesInterview> grid = new Grid<RaymondJamesInterview>(RaymondJamesInterview.class);
	private TextField howAreYou = new TextField();
	private Button save = new Button("Save", e -> saveInterviewer());
	private TextField InterviewerID = new TextField("Find ID");
	private Button find = new Button("Find", e -> find());
	private Button reset = new Button("Reset Form", e -> updateGrid());
	private PopupView popUp = new PopupView();
	private Label welcome = new Label ("RAYMOND JAMES INTERVIEW");

	@Override
	protected void init(VaadinRequest request) {
		updateGrid();
		grid.setColumns("id", "interviewStartTime", "interviewEndTime", "firstName", "lastName", "title", "howAreYou");
		grid.setWidth("1200px");
		grid.addSelectionListener(e -> updateForm());	
		binder.bindInstanceFields(this);
		VerticalLayout layout = new VerticalLayout(welcome, InterviewerID, find, reset, popUp, grid, howAreYou, save);
		layout.setComponentAlignment(welcome, Alignment.TOP_CENTER);
		reset.setVisible(false);
		setContent(layout);
	}

	private void updateGrid() {
		List<RaymondJamesInterview> raymondJamesInterviews = service.getAllInterviews();
		grid.setItems(raymondJamesInterviews);
		setFormVisible(false);
		reset.setVisible(false);
		InterviewerID.clear();
		popUp.setVisible(false);
	}

	private void updateForm() {
		if (grid.asSingleSelect().isEmpty()) {
			setFormVisible(false);
		} else {
			raymondJamesInterview = grid.asSingleSelect().getValue();
			binder.setBean(raymondJamesInterview);
			setFormVisible(true);
		}
	}

	private void setFormVisible(boolean visible) {
		if(binder.getBean()!=null)
		howAreYou.setCaption("Hi "+binder.getBean().getFirstName()+", how are you?");		
		howAreYou.setVisible(visible);
		save.setVisible(visible);
	}

	private void saveInterviewer() {
		service.saveorUpdateInterviewer(raymondJamesInterview);
		updateGrid();
	}

	private void find() {
		if (formUtil.isNumeric(InterviewerID.getValue())) {
			List<RaymondJamesInterview> raymondJamesInterviews = new ArrayList<RaymondJamesInterview>(
					Arrays.asList(service.findInterviewerByID(Long.valueOf(InterviewerID.getValue()))));
			if (raymondJamesInterviews.get(0) != null) {
				grid.setItems(raymondJamesInterviews);
				setFormVisible(false);
				reset.setVisible(true);
				popUp.setVisible(false);
			} else {
				popUp("ID NOT FOUND");
			}
		} else {
			popUp("INVALID ID");
		}
	}

	private void popUp(String popMessage) {
		updateGrid();
		popUp.setCaption(popMessage);
		popUp.setVisible(true);

	}

}
