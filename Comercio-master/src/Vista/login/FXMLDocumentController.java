/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.login;

import Datos.BDA;
import Modelo.Trabajador;
import Vista.menu.FXMLVistaPrincipalController;
import Vista.rutas.RutasController;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Borja
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private TextField usuario;
    @FXML
    private TextField contra;
    @FXML
    private Button login;
    BDA b = new BDA();
    @FXML
    private Label conexion;
    Trabajador t;
    Stage escenario;
    Comercio c;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            b.conectar();
            conexion.setText("CONECTADO");
            conexion.setStyle("-fx-text-fill:green");
        } catch (SQLException ex) {
            conexion.setText("DESCONECTADO");
            conexion.setStyle("-fx-text-fill:red");
        }
    }

    @FXML
    private void clicarLogin(MouseEvent event) throws SQLException, IOException{
        int user = Integer.parseInt(usuario.getText());
        user=1;
        t = b.consultar(Integer.parseInt(usuario.getText()));

        if (t.getIdTrabajador() == user && t.getContraseña().equals(contra.getText())) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
//            a.setTitle("Correcto");
//            a.setHeaderText("El usuario ha sido registrado");
//            a.show();
            FXMLLoader loader = new FXMLLoader(); 
            loader.setLocation(getClass().getResource("/Vista/menu/Menu.fxml"));
           
            Parent root = loader.load();
           ((FXMLVistaPrincipalController) loader.getController()).setBda(b);
            escenario = new Stage();
            escenario.setTitle("Menu principal");
            escenario.initModality(Modality.APPLICATION_MODAL);
            escenario.setScene(new Scene(root));
            escenario.showAndWait();
            Stage stage=(Stage) login.getScene().getWindow();
            
            
        } else {

            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("El usuario o contraseña son incorrectos");
            a.show();
        }

    }

}
