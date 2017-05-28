/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.horario;

import Datos.BDA;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import jfxtras.scene.control.CalendarPicker;

/**
 * FXML Controller class
 *
 * @author daw
 */
public class HorarioController implements Initializable {

    @FXML
    private CalendarPicker calendario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        calendario
        // TODO
    }    

    public void sedatBda(BDA bda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
