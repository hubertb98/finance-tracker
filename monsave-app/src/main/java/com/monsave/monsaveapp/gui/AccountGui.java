package com.monsave.monsaveapp.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class AccountGui extends VerticalLayout {
    public AccountGui() {
        Tabs tabs = new Tabs();
        Tab account = new Tab("Accounts");
        Tab records = new Tab("Records");
        tabs.add(account, records);
        tabs.setSelectedTab(account);
        add(tabs);

        Div divAddAccount = new Div();
        divAddAccount.setText("Accounts");
        Button buttonAddAccount = new Button("+ Add");

        Dialog addAccountDialog = new Dialog();
        FormLayout addAccountLayout = new FormLayout();
        TextField accountName = new TextField("Name", "Account name");
        TextField amount = new TextField("Starting Amount", "0");
        Button buttonSaveAccount = new Button("Save");

        addAccountLayout.add(accountName, amount, buttonSaveAccount);
        addAccountDialog.add(addAccountLayout);

        buttonAddAccount.addClickListener(event -> addAccountDialog.open());

        add(buttonAddAccount, addAccountDialog);
    }
}
