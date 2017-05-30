/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.GestionTiendas;

import Datos.BDA;
import Modelo.Incidencias;
import Modelo.Tienda;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class GestionTiendasController implements Initializable {

    @FXML
    private TabPane tabPane_Comercio;
    @FXML
    private Tab tab_infoTiendas;
    @FXML
    private TableColumn<Tienda, Integer> colum_idTienda;
    @FXML
    private TableColumn<Tienda, String> colum_pueblo;
    @FXML
    private TableColumn<Tienda, String> colum_direccion;
    @FXML
    private TableColumn<Tienda, String> colum_telefono;
    @FXML
    private TableColumn<Tienda, String> colum_CodigoPostal;
    @FXML
    private Tab tab_NuevoCmabiarTienda;
    @FXML
    private Button bt_cambiar;
    @FXML
    private Button bt_eliminar;
    @FXML
    private Button bt_guardar;
    @FXML
    private Button bt_guardarCambios;
    @FXML
    private TextField text_codigoTienda;
    @FXML
    private TextField text_pueblo;
    @FXML
    private TextField text_direccion;
    @FXML
    private TextField text_telefono;
    @FXML
    private TextField text_codigoPostal;
    @FXML
    private TableView<Tienda> tableView;

    private ObservableList<Tienda> listaTiendasObser;

    Tienda tienda;
    List<Tienda> lista;
    Alert a;
    boolean entro;

    BDA bdd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        entro = true;

        try {
            bdd = new BDA();
            lista = bdd.listarTiendas();

            listaTiendasObser = FXCollections.observableArrayList(lista);
            tableView.setItems(listaTiendasObser);

            colum_idTienda.setCellValueFactory(new PropertyValueFactory<>("idTienda"));
            colum_pueblo.setCellValueFactory(new PropertyValueFactory<>("pueblo"));
            colum_direccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
            colum_telefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
            colum_CodigoPostal.setCellValueFactory(new PropertyValueFactory<>("codPostal"));

            bt_guardarCambios.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GestionTiendasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void cambiar(ActionEvent event) {
        tab_NuevoCmabiarTienda.getGraphic();
        SingleSelectionModel<Tab> selectionModel = tabPane_Comercio.getSelectionModel();
        selectionModel.select(tab_NuevoCmabiarTienda);

        tienda = tableView.getSelectionModel().getSelectedItem();

        String id = String.valueOf(tienda.getIdTienda());
        if (id == null) {
            bt_guardarCambios.setVisible(false);
        }
        text_codigoTienda.setText(id);
        bt_guardar.setVisible(false);
        bt_guardarCambios.setVisible(true);

    }

    @FXML
    private void eliminarTienda(ActionEvent event) throws SQLException {

        tienda = tableView.getSelectionModel().getSelectedItem();

        if (bdd.consultarIDtienda(tienda.getIdTienda()) == true) {

            if (bdd.borrarTienda(tienda.getIdTienda()) != 0) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Informacion");
                a.setHeaderText("Tienda borrada");
                a.show();
            }

        } else {
            a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Id tienda no encontrada");
            a.show();
        }

    }

    @FXML
    private void guardar(ActionEvent event) {
        Integer idTienda = Integer.valueOf(text_codigoTienda.getText());

        try {
            if (bdd.insertarTienda(idTienda, text_pueblo.getText(), text_direccion.getText(), text_telefono.getText(), text_codigoPostal.getText()) != 0) {
                a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Informacion");
                a.setHeaderText("Tienda Insertada");
                a.show();

            }
        } catch (SQLException ex) {
            a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Datos introducidos erroneos");
            a.show();
        }
    }

    @FXML
    private void guardarCambios(ActionEvent event) throws SQLException {
        Integer idTienda = Integer.valueOf(text_codigoTienda.getText());
        if (bdd.consultarIDtienda(idTienda) == true) {

            if (bdd.cambiarTiendas(idTienda, text_pueblo.getText(), text_direccion.getText(), text_telefono.getText(), text_codigoPostal.getText()) != 0) {
                a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Informacion");
                a.setHeaderText("Tienda modificada");
                a.show();
            }

        } else {
            a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Id tienda no encontrada");
            a.show();
        }
    }

    @FXML
    private void cambioPestaña(Event event) {
        if (tab_NuevoCmabiarTienda.isSelected()) {

            bt_guardar.setVisible(true);
            bt_guardarCambios.setVisible(false);
            
            text_codigoTienda.setText("");
            text_direccion.setText("");
            text_codigoPostal.setText("");
            text_pueblo.setText("");
            text_telefono.setText("");
        }

        bt_guardar.setVisible(true);
        bt_guardarCambios.setVisible(false);

    }

    @FXML
    private void clicarInformacionTiendas(Event event) throws SQLException {

        if (entro == true) {

            if (tab_infoTiendas.isSelected()) {
                listaTiendasObser.clear();
                lista = bdd.listarTiendas();
                listaTiendasObser.addAll(lista);
            }
        }
    }

}
