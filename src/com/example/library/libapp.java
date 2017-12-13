package com.example.library;

import java.io.IOException;

import com.example.library.view.logincontroller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class libapp {
	private Stage primaryStage;
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public void init() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Init Called");
		System.out.println(Thread.currentThread().getName());
		
		//called before start on JavaFX launcher thread
		//good place to initialize non gui objects required in your app
	}

	public void start(Stage primaryStage) {
		
		//runs on the JavaFX Application Thread after init
		System.out.println("Start called");
		System.out.println(Thread.currentThread().getName());
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Library Management App");
		this.primaryStage.setWidth(600);
		this.primaryStage.setHeight(400);
		this.primaryStage.show();		//makes the stage visible
		
		showLoginScene();
	}
	
	public void showLoginScene(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(libapp.class.getResource("view/Login.fxml"));
		
		try {
			Pane Pane = loader.load();
			logincontroller lc=loader.getController();
			lc.setApp(this);
			//create the scene with the GridPane as the parent
			Scene scene = new Scene(Pane);
			
			//set the scene on the stage
			this.primaryStage.setScene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block			e.printStackTrace();
		}
		}


}
