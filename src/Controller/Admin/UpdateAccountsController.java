/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Admin;

import Model.Accounts;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author M.IB.MH
 */
public class UpdateAccountsController implements Initializable {

    
     private Accounts oldAccount;
    
    @FXML
    private Button updateAccountsBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField AccountnumberTF;
    @FXML
    private TextField UserNameTF;
    @FXML
    private TextField CurrencyTF;
    @FXML
    private TextField BalanceTF;
    @FXML
    private TextField CreationDateTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.oldAccount = Controller.Admin.AccountsManagmentController.selectedAccountsToUpdate;
        
    //    AccountnumberTF.setText(oldAccount.getAccountNumber());
        UserNameTF.setText(oldAccount.getUsername());
        CurrencyTF.setText(oldAccount.getCurrency());
    //    BalanceTF.setText(oldAccount.getBalance());
    //   CreationDateTF.setText(oldAccount.getCreationDate());
        
        
        
        
        
        
       
    }    

    @FXML
    private void updateAccounts(ActionEvent event) {
        
        Integer Account_number  = Integer.parseInt(AccountnumberTF.getText());
        String username = UserNameTF.getText();
        String Currency = CurrencyTF.getText();
        Integer balance = Integer.parseInt(BalanceTF.getText());
        long Creation_Date = Date.parse(CreationDateTF.getText());
     
        Accounts newaccount = new Accounts(Account_number , username, Currency , balance , Creation_Date);
        

        
    }

    @FXML
    private void cancelCreation(ActionEvent event) {
    }
    
}
