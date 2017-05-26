/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.GestionTrabajadores;

import Datos.BDA;
import Modelo.Trabajador;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class GestionTrabajadoresController implements Initializable {
    BDA bda;

    public void setBda(BDA bda) {
        this.bda = bda;
    }
    
    @FXML
    private Button añadirTrabajor;
    @FXML
    private Button añadirTrabajor1;
    @FXML
    private TableView<Trabajador> tableView;
    @FXML
    private TableColumn<Trabajador, Integer> idColum;
    @FXML
    private TableColumn<Trabajador, String> nombreColum;
    @FXML
    private TableColumn<Trabajador, String> puestoColum;
    @FXML
    private TableColumn<Trabajador, String> dniColum;
    @FXML
    private TableColumn<Trabajador, Double> salarioColum;
    @FXML
    private TableColumn<Trabajador, String> ContraseñaColum;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void añadirTrabajador(ActionEvent event) {
    }
    
}
