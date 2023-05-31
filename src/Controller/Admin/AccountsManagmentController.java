/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.Accounts;
import View.ViewManager;
import com.sun.istack.internal.logging.Logger;
import java.io.IOException;
import static java.lang.Math.E;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.logging.Level;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Yahya
 */
public class AccountsManagmentController implements Initializable {

    public static Accounts selectedAccountsToUpdate;
    public static Stage updateStage;

    @FXML
    private Button usersManagmentPageBtn;
    @FXML
    private Button accountsPageBtn;
    @FXML
    private Button operationsPageBtn;
    @FXML
    private Button createNewAccountrBtn;
    @FXML
    private Button showAllAccountsBtn;
    @FXML
    private Button updateSelectedAccountBtn;
    @FXML
    private Button deleteSelectedAccountBtn;
    @FXML
    private Button searchAccountBtn;
    @FXML
    private TextField accontSearchTF;
    @FXML
    private TableView<Accounts> AccountTableView;
    @FXML
    private TableColumn<Accounts, Integer> idcol;
    @FXML
    private TableColumn<Accounts, Integer> Accountnumbercol;
    @FXML
    private TableColumn<Accounts, String> UserNamecol;
    @FXML
    private TableColumn<Accounts, String> Currencycol;
    @FXML
    private TableColumn<Accounts, Integer> Balancecol;
    @FXML
    private TableColumn<Accounts, Date> CreationDatecol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        idcol.setCellValueFactory(new PropertyValueFactory("id"));
        Accountnumbercol.setCellValueFactory(new PropertyValueFactory("Account number"));
        UserNamecol.setCellValueFactory(new PropertyValueFactory("User Name"));
        Currencycol.setCellValueFactory(new PropertyValueFactory("Currency"));
        Balancecol.setCellValueFactory(new PropertyValueFactory("Balance"));
        CreationDatecol.setCellValueFactory(new PropertyValueFactory("Creation Date"));

    }

    @FXML
    private void showUsersManagmentPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToUsersManagment();
    }

    @FXML
    private void showAccountsPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToAccountsManagment();

    }

    @FXML
    private void showOperationsPage(ActionEvent event) {
    }

    @FXML
    private void showAccountCreationPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToUsersManagment();

    }

    @FXML
    private void showAllAccounts(ActionEvent event) throws ClassNotFoundException, SQLException {
        
            // يظهر error 
//           ObservableList<Accounts> AccountList =
//            FXCollections.observableArrayList(Accounts.getAllAccounts)
//      AccountTableView.setItems(AccountList);  

    }

    @FXML
    private void updateSelectedAccount(ActionEvent event) throws IOException {
        if (AccountTableView.getSelectionModel().getSelectedItem() != null) {
            selectedAccountsToUpdate = AccountTableView.getSelectionModel().getSelectedItem();
            FXMLLoader loaderUpdate = new FXMLLoader(getClass().getResource("/View/AdminFXML/updateAccounts.fxml"));
            Parent rootUpdate = loaderUpdate.load();
            Scene updateAccountScene = new Scene(rootUpdate);
            updateStage = new Stage();
            updateStage.setScene(updateAccountScene);
            updateStage.setTitle("update Accounts " + selectedAccountsToUpdate.getUsername());
            updateStage.show();
        }
    }

    @FXML
    private void deleteSelectedAccount(ActionEvent event) {

        if (AccountTableView.getSelectionModel().getSelectedItem() != null) {

            Accounts selectedAccount = AccountTableView.getSelectionModel().getSelectedItem();
            Alert deleteConfirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deleteConfirmAlert.setTitle("Account delete");
            deleteConfirmAlert.setContentText("Are you sure to delete this Account ?");
            deleteConfirmAlert.showAndWait().ifPresent(new Consumer<ButtonType>() {
                @Override
                public void accept(ButtonType response) {
                    if (response == ButtonType.OK) {
                        selectedAccount.delete();
                        Alert deletedSuccessAlert = new Alert(Alert.AlertType.INFORMATION);
                        deletedSuccessAlert.setTitle("User deleted");
                        deletedSuccessAlert.setContentText("User deleted");
                        deletedSuccessAlert.show();
                    }
                }
            });

            
        }else{
        Alert warnAlert = new Alert(Alert.AlertType.WARNING);
        warnAlert.setTitle("Select an Account");
        warnAlert.setContentText("Please select an Account from the table view");
        warnAlert.show(); 
        }
    }

    @FXML
    private void searchForAnAccount(ActionEvent event
    ) {
    }

}
