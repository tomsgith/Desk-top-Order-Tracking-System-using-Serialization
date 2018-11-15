package views.view;

import java.io.IOException;

import dataacces.Auth;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import views.Main;

public class loginController extends Main {
	@FXML
	 TextField uId;
	@FXML
	 TextField pass;
	@FXML
	 Label error;
@FXML
public void GotoAdmin() throws IOException {
	Main.administratorFrame();
}
@FXML
public void GotoCustomer() throws IOException {
	Main.customerFrame();
}
public void LogIn() throws IOException {
	
	 Auth s= logIn(uId.getText(), pass.getText()) ;
	if(s==null) error.setText("Enter valid Id or Password");
	else if(s.equals(Auth.ADMIN)) GotoAdmin();
	else {
		//customer id is set during login
		id=uId.getText();
		GotoCustomer();
	}
	}
}

