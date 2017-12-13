package com.example.library.view;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.library.libapp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
public class logincontroller {
	private libapp app;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	
	
	public void setApp(libapp app){
		this.app=app;
	}
	@FXML
	private void onLoginclick() throws SQLException, ClassNotFoundException{
		String user=username.getText();
		String pass=password.getText();
		
		Connection connection = DbUtil.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
		String query="select * from users where username=? password=?";
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setString(1, user);
		ps.setString(2, pass);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			
			Alert alert= new Alert(AlertType.INFORMATION);
			alert.setTitle("Log In");
			alert.setContentText("Logged In Successfully");
			alert.initOwner(this.app.getPrimaryStage());
			alert.showAndWait();
			}
		else{
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Login Failed");
			alert.setContentText("Logged In Failed");
			alert.initOwner(this.app.getPrimaryStage());
			alert.showAndWait();
			
		
		}
	}

}
