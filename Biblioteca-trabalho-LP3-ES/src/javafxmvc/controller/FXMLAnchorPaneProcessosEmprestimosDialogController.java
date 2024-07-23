package javafxmvc.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javafxmvc.model.dao.UsuarioDAO;
import javafxmvc.model.database.Database;
import javafxmvc.model.database.DatabaseFactory;
import javafxmvc.model.domain.Emprestimo;
import javafxmvc.model.domain.Usuario;

public class FXMLAnchorPaneProcessosEmprestimosDialogController implements Initializable {

    @FXML
    private DatePicker datePickerEmprestimoData;
    @FXML
    private ComboBox<Usuario> comboBoxEmprestimoUsuario;
    @FXML
    private Button buttonConfirmar;
    @FXML
    private Button buttonCancelar;

    private List<Usuario> listUsuarios;
    private ObservableList<Usuario> observableListUsuarios;

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Emprestimo emprestimo;

    // Atributos para manipulação de Banco de Dados
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuarioDAO.setConnection(database.conectar());
        carregarComboBoxUsuarios();
    }

    public void carregarComboBoxUsuarios() {
        listUsuarios = usuarioDAO.listar();
        observableListUsuarios = FXCollections.observableArrayList(listUsuarios);
        comboBoxEmprestimoUsuario.setItems(observableListUsuarios);
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
        this.datePickerEmprestimoData.setValue(emprestimo.getDataEmprestimo());
        this.comboBoxEmprestimoUsuario.setValue(emprestimo.getUsuario());
    }

    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    @FXML
    public void handleButtonConfirmar() {
        if (validarEntradaDeDados()) {
            emprestimo.setDataEmprestimo(datePickerEmprestimoData.getValue());
            emprestimo.setUsuario(comboBoxEmprestimoUsuario.getValue());

            buttonConfirmarClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    public void handleButtonCancelar() {
        dialogStage.close();
    }

    private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (datePickerEmprestimoData.getValue() == null) {
            errorMessage += "Data inválida!\n";
        }
        if (comboBoxEmprestimoUsuario.getValue() == null) {
            errorMessage += "Usuário inválido!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos inválidos, por favor corrija...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }
}
