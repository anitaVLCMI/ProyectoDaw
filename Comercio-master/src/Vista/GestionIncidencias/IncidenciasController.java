/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.GestionIncidencias;

import Datos.BDA;
import Modelo.Incidencias;

import java.net.URL;
import java.sql.Date;

import static java.sql.JDBCType.DATE;
import java.sql.SQLException;
import static java.sql.Types.DATE;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import jfxtras.scene.control.CalendarTextField;
import jfxtras.scene.control.CalendarTimeTextField;
import jfxtras.scene.control.LocalDateTextField;
import jfxtras.scene.control.LocalTimeTextField;
import org.apache.derby.client.am.DateTime;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class IncidenciasController implements Initializable {

    @FXML
    private Button bt_eliminarInci;
    @FXML
    private Button bt_ModifiInci;
    @FXML
    private TableView<Incidencias> tableView;

    private ObservableList<Incidencias> listaIncidencias;

    BDA bdd;
    @FXML
    private Label label_Incidencias;

    @FXML
    private TableColumn<Incidencias, String> descripcion;
    @FXML
    private TableColumn<Incidencias, Integer> idTrabajador;
    @FXML
    private TableColumn<Incidencias, Integer> idTienda;
    @FXML
    private TableColumn<Incidencias, Integer> idIncidencias;
    @FXML
    private Tab tab_inci;
    @FXML
    private Tab tab_CambiosInci;
    @FXML
    private TabPane tabPaneInci;
    @FXML
    private TextField textF_idIncidencia;
    @FXML
    private TextField textf_idTrabajador;
    @FXML
    private TextField textF_idTienda;
    ;
    @FXML
    private TextArea textArea_descripcion;
    @FXML
    private Button bt_guardar;
    @FXML
    private LocalTimeTextField txfield_hora;

    @FXML
    private LocalDateTextField txField_fecha;
    @FXML
    private TableColumn<Incidencias, String> tab_fecha;
    Incidencias incidencia;
    @FXML
    private Button bt_guardarCam;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {

            bdd = new BDA();
            List<Incidencias> lista = bdd.listarIncidencias();

            listaIncidencias = FXCollections.observableArrayList(lista);

            tableView.setItems(listaIncidencias);

            idIncidencias.setCellValueFactory(new PropertyValueFactory<>("idIncidencias"));
            descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
            idTrabajador.setCellValueFactory(new PropertyValueFactory<>("idTrabajador"));
            idTienda.setCellValueFactory(new PropertyValueFactory<>("idTienda"));
            tab_fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));

            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            txField_fecha.setDateTimeFormatter(format);
            bt_guardarCam.setDisable(true);
        } catch (SQLException ex) {
            Logger.getLogger(IncidenciasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void borrarInci(ActionEvent event) throws SQLException {

        ///Conseguir values de tableView
        incidencia = tableView.getSelectionModel().getSelectedItem();

        if (incidencia.consultarIDincidencia(incidencia.getIdIncidencias()) == true) {

            bdd.borrarIncidencia(incidencia.getIdIncidencias());

        }

    }

    @FXML
    private void cambiar(ActionEvent event) {
        tab_CambiosInci.getGraphic();
        SingleSelectionModel<Tab> selectionModel = tabPaneInci.getSelectionModel();
        selectionModel.select(tab_CambiosInci);

        incidencia = tableView.getSelectionModel().getSelectedItem();
        String id=String.valueOf(incidencia.getIdIncidencias());
        textF_idIncidencia.setText(id);
        bt_guardar.setDisable(true);
        bt_guardarCam.setDisable(false);
    }

    @FXML
    private void guardar(ActionEvent event) throws SQLException {
        int idIncidencias = Integer.valueOf(textF_idIncidencia.getText());
        int idTrabajador = Integer.valueOf(textf_idTrabajador.getText());
        int idtienda = Integer.valueOf(textF_idTienda.getText());

        String fecha = txField_fecha.getText() + " " + txfield_hora.getLocalTime();

        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");

//        String fecha2=formato.format(fecha);
        String descripcion = textArea_descripcion.getText();

        bdd.insertarIncidencia(idIncidencias, idTrabajador, idtienda, fecha, descripcion);
    }

    @FXML
    private void guuardarCambios(ActionEvent event) throws SQLException {
        
        int idIncidencias = Integer.valueOf(textF_idIncidencia.getText());
        int idTrabajador = Integer.valueOf(textf_idTrabajador.getText());
        int idtienda = Integer.valueOf(textF_idTienda.getText());

        String fecha = txField_fecha.getText() + " " + txfield_hora.getLocalTime();

        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");

//        String fecha2=formato.format(fecha);
        String descripcion = textArea_descripcion.getText();

        bdd.cambiarIncidencia(idIncidencias, idTrabajador, idtienda, fecha, descripcion);
    }

}
