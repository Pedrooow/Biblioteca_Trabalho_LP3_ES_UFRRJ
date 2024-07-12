package javafxmvc.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class FXMLVBoxMainController implements Initializable {

    @FXML
    private MenuItem menuItemCadastrosClientes;
    
    @FXML
    private MenuItem menuItemCadastrosUsuarios;
    
    @FXML
    private MenuItem menuItemProcessosVendas;
    
    @FXML
    private MenuItem menuItemCadastrosAutores;
    
    @FXML
    private MenuItem menuItemGraficosVendasPorMes;
    
    @FXML
    private MenuItem menuItemRelatoriosQuantidadeProdutos;

    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private MenuItem menuItemCadastrosEditoras;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void handleMenuItemCadastrosClientes() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafxmvc/view/FXMLAnchorPaneCadastrosClientes.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    @FXML
    public void handleMenuItemCadastrosUsuarios() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafxmvc/view/FXMLAnchorPaneCadastrosUsuarios.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    @FXML
    public void handleMenuItemCadastrosEditoras() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafxmvc/view/FXMLAnchorPaneCadastrosEditoras.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    @FXML
    public void handleMenuItemCadastrosAutores() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafxmvc/view/FXMLAnchorPaneCadastrosAutores.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    
    @FXML
    public void handleMenuItemProcessosVendas() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafxmvc/view/FXMLAnchorPaneProcessosVendas.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    
    @FXML
    public void handleMenuItemGraficosVendasPorMes() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafxmvc/view/FXMLAnchorPaneGraficosVendasPorMes.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    
    @FXML
    public void handleMenuItemRelatoriosQuantidadeProdutos() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafxmvc/view/FXMLAnchorPaneRelatoriosQuantidadeProdutos.fxml"));
        anchorPane.getChildren().setAll(a);
    }

}
