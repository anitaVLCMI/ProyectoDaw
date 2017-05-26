/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.rutas;

import Datos.BDA;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Borja
 */
public class RutasController implements Initializable {

    BDA bda;

    @FXML
    private TextField id;
    @FXML
    private Label idRuta;
    @FXML
    private TextField kilometros;
    @FXML
    private TextField trabajador;
    @FXML
    private TextField minutos;
    @FXML
    private TextField gastos;
    @FXML
    private Button insertar;

    public void setBda(BDA bda) {
        this.bda = bda;
    }

    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clicarinsertarRuta(MouseEvent event) {
        try {
            Integer ruta = Integer.parseInt(id.getText());
            Double kilometro = Double.parseDouble(kilometros.getText());
            Integer traba = Integer.parseInt(trabajador.getText());
            Integer min = Integer.parseInt(minutos.getText());
            Double gasto = Double.parseDouble(gastos.getText());

            bda.insertarRuta(ruta, kilometro, traba, min, gasto);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Ruta");
            a.setHeaderText("La ruta a sido introducida con exito");
            a.show();
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Ruta");
            a.setHeaderText("Error al insertar la ruta");
            a.show();
        }
    }

}
