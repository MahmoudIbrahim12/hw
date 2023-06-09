/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author M.IB.MH
 */
public class Accounts1 {
    
    private int id;
    private int user_id;
    private int account_number;
    private String username;
    private String currency;
    private double balance;
    private Date creation_date;
    
    public Accounts1(int id, int user_id, int account_number, String username, String currency, double balance, Date creation_date) {
        this.id = id;
        this.user_id = user_id;
        this.account_number = account_number;
        this.username = username;
        this.currency = currency;
        this.balance = balance;
        this.creation_date = creation_date;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getUser_id() {
        return user_id;
    }
    
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    public int getAccount_number() {
        return account_number;
    }
    
    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public Date getCreation_date() {
        return creation_date;
    }
    
    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
    
    public int save() throws SQLException, ClassNotFoundException {
        
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "INSERT INTO ACCOUNT (ID,UESR_ID,ACCOUNTS_NUMBER,USERNAME,CURRENCY,BALANCE,CREATION_DATE) VALUES (?, ?, ?, ?,?,?,?)";
        ps = c.prepareStatement(sql);
        
        ps.setInt(1, this.getId());        
        ps.setInt(2, this.getUser_id());
        ps.setInt(3, this.getAccount_number());
        ps.setString(4, this.getUsername());
        ps.setString(5, this.getCurrency());
        ps.setDouble(6, this.getBalance());
        ps.setDate(7, (java.sql.Date) this.getCreation_date());
        

        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println(this.getUsername()
                    + " Accounts was added successfully!");
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordCounter;        
    }

    public static ArrayList<Accounts> getAllAccounts() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Accounts> accounts = new ArrayList<>();
        String sql = "SELECT * FROM ACCOUNTS ";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {

//      Accounts account = new Accounts(rs.getInt(2), rs.getInt(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getDate(7));
//        //   Accounts account = new Accounts(rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
//
//           account.setId(rs.getInt(1));
//            accounts.add(account);
//            
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return accounts;
    }
    
    public int update() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter =0;
        String sql = "UPDATE ACCOUNTS SET UESR_ID=?,ACCOUNTS_NUMBER =?, USERNAME=? , CURRENCY=?,BALANCE=?, CREATION_DATE=? WHERE ID=?";
        ps = c.prepareStatement(sql);
        
              
        ps.setInt(1, this.getUser_id());
        ps.setInt(2, this.getAccount_number());
        ps.setString(3, this.getUsername());
        ps.setString(4, this.getCurrency());
        ps.setDouble(5, this.getBalance());
        ps.setDate(6, (java.sql.Date) this.getCreation_date());
        ps.setInt(7, this.getId());

        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("Acoounts with id : "+this.getId()+" was updated successfully!");
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;  
    }
    
     public int delete() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter =0;
        String sql = "DELETE FROM ACCOUNTS WHERE ID=? ";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getId());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("The Accounts with id : "+this.getId()+" was deleted successfully!");
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;  
    }
}
