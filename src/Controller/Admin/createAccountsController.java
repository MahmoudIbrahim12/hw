/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Admin;

import Model.Accounts;
import View.ViewManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author M.IB.MH
 */
public class createAccountsController implements Initializable {

    @FXML
    private Button usersManagmentPageBtn;
    @FXML
    private Button accountsPageBtn;
    @FXML
    private Button operationsPageBtn;
    @FXML
    private Button saveNewAccountsBtn;
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
        // TODO
    }

    @FXML
    private void showUsersManagmentPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }

    @FXML
    private void showAccountsPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }

    @FXML
    private void showOperationsPage(ActionEvent event) {
    }

    @FXML
    private void saveNewAccounts(ActionEvent event) {

        String Accountnumber = AccountnumberTF.getText();
        String UserName = UserNameTF.getText();
        String Currency = CurrencyTF.getText();
        String Balance = BalanceTF.getText();
        String CreationDate = CreationDateTF.getText();

        Accounts account = new Accounts(Integer.SIZE, 0, 0, UserName, Currency, 0);
        // account.save();

        //after saving should return to the back scene and show an alert
        ViewManager.adminPage.changeSceneToUsersManagment();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User inserted");
        alert.setContentText("User inserted");
        alert.showAndWait();

    }

    @FXML
    private void cancelAccountsCreation(ActionEvent event) {

        ViewManager.adminPage.changeSceneToAccountsManagment();

    }

}
