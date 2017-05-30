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
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Borja
 */
public class FXMLDocumentController implements Initializable {

    Trabajador t;
    Stage escenario;
    Comercio c;
    BDA b = new BDA();

    @FXML
    private TextField usuario;
    @FXML
    private TextField contra;
    @FXML
    private Button login;
    @FXML
    private AnchorPane panelLogin;
    @FXML
    private Pane paneLogin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            b.conectar();
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Error al conectar con la base de datos");
            a.show();
        }

    }

    @FXML
    private void clicarLogin(MouseEvent event) throws SQLException, IOException {
        List<Trabajador> lista = new ArrayList<>();
        String dni = usuario.getText();
        lista = b.consultar(usuario.getText());
        for (Trabajador t : lista) {
            if (t.getDNI().equals(dni) && t.getContraseña().equals(contra.getText())) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/Vista/menu/Menu.fxml"));
                Parent root = loader.load();
                ((FXMLVistaPrincipalController) loader.getController()).setBda(b);
                escenario = new Stage();
                escenario.setTitle("Menu principal");
                escenario.initModality(Modality.APPLICATION_MODAL);
                escenario.setScene(new Scene(root));
                Stage stage = (Stage) login.getScene().getWindow();
                stage.close();
                escenario.showAndWait();
            } else if(!t.getDNI().equals(dni) && !t.getContraseña().equals(contra.getText())){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("El usuario o contraseña son incorrectos");
                a.show();
            }
        }

    }

}
