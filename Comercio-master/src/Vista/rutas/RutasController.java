/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.rutas;

import Datos.BDA;
import Modelo.Ruta;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Borja
 */
public class RutasController implements Initializable {

    BDA bda;
    ObservableList<Ruta> listaRutas;
    @FXML
    private TextField id;
    @FXML
    private Label idRuta;
    @FXML
    private TextField kilometros;

    @FXML
    private TextField minutos;
    @FXML
    private TextField gastos;
    @FXML
    private Button insertar;
    @FXML
    private TableView<Ruta> table;
    @FXML
    private TableColumn<Ruta, Integer> rutaColum;
    @FXML
    private TableColumn<Ruta, Double> kilometrosColum;
    @FXML
    private TableColumn<Ruta, Integer> minutosColum;
    @FXML
    private TableColumn<Ruta, Double> gastosColum;
    @FXML
    private TextField ruta;
    @FXML
    private Button borrarRuta;
    @FXML
    private Button modificar;
    @FXML
    private TextField mGastos1;
    @FXML
    private TextField mMinutos1;
    @FXML
    private TextField mKilometros1;
    @FXML
    private TextField mId1;

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
            Integer min = Integer.parseInt(minutos.getText());
            Double gasto = Double.parseDouble(gastos.getText());

            bda.insertarRuta(ruta, kilometro, min, gasto);
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

    @FXML
    private void clicarInformacionRuta(Event event) throws SQLException {
        List<Ruta> lista;
        lista = bda.listarRutas();
        listaRutas = FXCollections.observableArrayList(lista);
        table.setItems(listaRutas);

        rutaColum.setCellValueFactory(new PropertyValueFactory<>("id"));
        kilometrosColum.setCellValueFactory(new PropertyValueFactory<>("Kilometros"));
        minutosColum.setCellValueFactory(new PropertyValueFactory<>("Minutos"));
        gastosColum.setCellValueFactory(new PropertyValueFactory<>("Gastos"));
    }

    @FXML
    private void clicarBorrar(MouseEvent event) {
        try {
            int idruta = Integer.parseInt(ruta.getText());
            bda.borrarRuta(idruta);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Rutas");
            a.setHeaderText("La ruta a sido borrado con exito");
            a.show();
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Error al borrar la ruta");
            a.show();
        }
    }

    @FXML
    private void cliclarModificarRuta(MouseEvent event) throws SQLException {

        Ruta r;
        int idruta = Integer.parseInt(mId1.getText());
        double kilometros1 = Double.parseDouble(mKilometros1.getText());
        int minutos1 = Integer.parseInt(mMinutos1.getText());
        double gastos1 = Double.parseDouble(mGastos1.getText());
        r = new Ruta(idruta, kilometros1, minutos1, gastos1);
        int filas = bda.modificarRuta(r);
        if (filas == 0) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("La id de la ruta no existe");
            a.show();
        } else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Rutas");
            a.setHeaderText("Ruta modificada con exito");
            a.show();
        }

    }

}
