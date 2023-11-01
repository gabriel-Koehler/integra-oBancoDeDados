package net.weg.api.view;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.IntegerField;
import net.weg.api.model.DTO.EnderecoCadastroDTO;
import net.weg.api.model.Endereco;

import java.awt.*;

public class CadastroEndereco extends FormLayout {
    private TextField bairro,rua;
    private IntegerField numero;
    private Button cancelar;
    private Button salvar;
    CadastroEndereco(Grid<EnderecoCadastroDTO> gridEndereco, Dialog dialog){
        salvar=new Button("Salvar",event-> gridEndereco.setItems(new EnderecoCadastroDTO(rua.getText(),bairro.getText(), numero.getValue())));
    }
}
