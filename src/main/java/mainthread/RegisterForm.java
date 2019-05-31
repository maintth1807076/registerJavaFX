package mainthread;

import entity.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.UserModel;

public class RegisterForm extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20));
        grid.setHgap(20);
        grid.setVgap(30);
        Label labelNotice = new Label();
        Label labelUsername = new Label("Username");
        Label labelPassword = new Label("Password");
        Label labelComfirmPassword = new Label("Comfirm Password");
        Label labelFullName = new Label("Full Name");
        Label labelEmail = new Label("Email");
        Label labelPhone = new Label("Phone");
        Button btnRegister = new Button("Submit");
        Button btnReset = new Button("Reset");
        TextField txtUsername = new TextField();
        PasswordField passwordField = new PasswordField();
        PasswordField comfirmPasswordField = new PasswordField();
        TextField txtFullName = new TextField();
        TextField txtEmail = new TextField();
        TextField txtPhone = new TextField();
        grid.add(labelNotice,0,0);
        grid.add(labelUsername,0,1);
        grid.add(labelPassword,0,2);
        grid.add(labelComfirmPassword,0,3);
        grid.add(labelFullName,0,4);
        grid.add(labelEmail,0,5);
        grid.add(labelPhone,0,6);
        grid.add(txtUsername,1,1);
        grid.add(passwordField,1,2);
        grid.add(comfirmPasswordField,1,3);
        grid.add(txtFullName,1,4);
        grid.add(txtEmail,1,5);
        grid.add(txtPhone,1,6);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(btnRegister,btnReset);
        hBox.setSpacing(40);
        grid.add(hBox,1,7);
        stage.setTitle("Register Form");
        stage.setScene(new Scene(grid,600,600));
        stage.show();
        btnRegister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = txtUsername.getText();
                String password = passwordField.getText();
                String comfirmPassword = comfirmPasswordField.getText();
                String fullName = txtFullName.getText();
                String email = txtEmail.getText();
                String phone = txtPhone.getText();
                if(!password.equals(comfirmPassword)){
                    labelNotice.setText("Mật khẩu không trùng khớp.");

                } else {
                    User user = new User(username,password,fullName,email,phone);
                    UserModel model = new UserModel();
                    model.insert(user);
                    labelNotice.setText("Đăng kí thành công.");
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
