package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
public class VaadinUI extends UI {

    @Autowired
    private CustomerService service;

    private Customer customer;

    private Binder<Customer> binder = new Binder<>(Customer.class);

    private Grid<Customer> grid = new Grid(Customer.class);
    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private Button save = new Button("Save", e -> saveCustomer());
    private TextField customerID = new TextField("Customer ID");
    private Button find = new Button("Find", e -> find());

    @Override
    protected void init(VaadinRequest request) {
        updateGrid();
        grid.setColumns("firstName", "lastName");
        grid.addSelectionListener(e -> updateForm());
        
        binder.bindInstanceFields(this);

        VerticalLayout layout = new VerticalLayout(customerID, find, grid, firstName, lastName, save);
        setContent(layout);
    }

    private void updateGrid() {
        List<Customer> customers = service.getAllCustomers();
        grid.setItems(customers);
        setFormVisible(false);
    }

    private void updateForm() {
        if (grid.asSingleSelect().isEmpty()) {
            setFormVisible(false);
        } else {
            customer = grid.asSingleSelect().getValue();
            binder.setBean(customer);
            setFormVisible(true);
        }
    }

    private void setFormVisible(boolean visible) {
        firstName.setVisible(visible);
        lastName.setVisible(visible);
        save.setVisible(visible);
    }

    private void saveCustomer() {
        service.saveorUpdateCustomer(customer);
        updateGrid();
    }
  
    private void find() {
    	List<Customer> customers =  new ArrayList<Customer>(Arrays.asList(service.findCustomerByID(Long.valueOf(customerID.getValue()))));    	
        grid.setItems(customers);
        setFormVisible(false);
    }

}
