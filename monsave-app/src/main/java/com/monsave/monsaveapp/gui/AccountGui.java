package com.monsave.monsaveapp.gui;

import com.monsave.monsaveapp.domain.Account;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.math.BigDecimal;

@Route
public class AccountGui extends VerticalLayout {
    private Account account;

    public AccountGui(final Tabs tabs, final Tab tabAccounts, final Tab tabRecords, final Div divAddAccount,
                      final Button buttonAddAccount, final Dialog addAccountDialog, final FormLayout addAccountLayout,
                      final TextField accountName, final NumberField amount, final Button buttonSaveAccount) {

        tabAccounts.setLabel("Accounts");
        tabRecords.setLabel("Records");
        tabs.add(tabAccounts, tabRecords);
        tabs.setSelectedTab(tabAccounts);
        add(tabs);

        divAddAccount.setText("Accounts");
        buttonAddAccount.setText("+ Add");

        accountName.setLabel("Name");
        accountName.setPlaceholder("Account name");
        amount.setLabel("Starting Amount");
        amount.setPlaceholder( "0");
        buttonSaveAccount.setText("Save");

        addAccountLayout.add(accountName, amount, buttonSaveAccount);
        addAccountDialog.add(addAccountLayout);

        buttonAddAccount.addClickListener(event -> {
            addAccountDialog.open();
        });
        buttonSaveAccount.addClickListener(event -> {
            try {
                /*todo popracić, bo wyskakuje NullPointerException */
                account.setName(accountName.getValue());
                account.getBalance().setStartingBalance(BigDecimal.valueOf(amount.getValue()));
                addAccountDialog.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        });

        add(buttonAddAccount, addAccountDialog);
    }
}
