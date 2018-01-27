package framework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class Main extends Application {

    Stage window;
    static String fullName, publicKey, walletFileAddress;
    protected  static Web3j web3j;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../../resources/LoginView.fxml"));
        window.setTitle("Ether Samaj");
        window.initStyle(StageStyle.TRANSPARENT);

        final double[] xoffset = new double[1];  // This is because variables used in lambda expression should
        final double[] yoffset = new double[1];  // final or effectively final. And IDE suggested this method

        root.setOnMousePressed(e -> {
            xoffset[0] = e.getSceneX();
            yoffset[0] = e.getSceneY();
        });

        root.setOnMouseDragged(e -> {
            primaryStage.setX(e.getScreenX() - xoffset[0]);
            primaryStage.setY(e.getScreenY() - yoffset[0]);
        });


        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
//        final String authUser = "edcguest";
//        final String authPassword = "edcguest";
//        Authenticator.setDefault(
//                new Authenticator() {
//                    @Override
//                    public PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(authUser, authPassword.toCharArray());
//                    }
//                }
//        );
//        System.setProperty("http.proxyHost", "172.31.52.54");
//        System.setProperty("http.proxyPort", "3128");
//        System.setProperty("http.proxyUser", authUser);
//        System.setProperty("http.proxyPassword", authPassword);
        launch(args);
    }
}