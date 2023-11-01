package net.weg.api.view;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import net.weg.api.model.DTO.EnderecoCadastroDTO;
import net.weg.api.model.DTO.UsuarioCadastroDTO;
import net.weg.api.service.ClienteService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Route(value = "/cadastro-usuario",layout = NavBarApp.class)
public class CadastroUsuario extends FormLayout {

    private final ClienteService clienteService;
    private TextField nome;
    private PasswordField senha;
    private PasswordField confirmacaoSenha;
    private IntegerField idade;
    private Grid<EnderecoCadastroDTO> enderecos;
    private Dialog enderecoCadastro;
    private Button novoEndereco;
    private Button cadastrar;
    private Button cancelar;


    CadastroUsuario(ClienteService clienteService) {
        this.clienteService = clienteService;
        add(
                nome = new TextField("Usuario"),
                senha = new PasswordField("Senha"),
                confirmacaoSenha = new PasswordField("Confirmação Senha"),
                idade = new IntegerField("Idade"),
                enderecos = new Grid<>(EnderecoCadastroDTO.class),
                enderecoCadastro = new Dialog(),
                novoEndereco = new Button("Novo Endereco", event -> enderecoCadastro.open()),
                cadastrar = new Button("Cadastrar", event -> {
                    Set<EnderecoCadastroDTO> listaDeEnderecos = new HashSet<>();
                    try {
                        if (senha.getValue().equals(confirmacaoSenha.getValue()))
                            clienteService.salvar(new UsuarioCadastroDTO(
                                    nome.getValue(),
                                    senha.getValue(),
                                    idade.getValue(),
                                    listaDeEnderecos
                            ));
                        new Notification("Usuario cadastrado com sucesso!", 3000).open();
                    } catch (Exception e) {
                        new Notification("Erro ao cadastrar usuario!", 3000).open();
                    } finally {
                        new Notification().open();
                    }
                }
                ),cancelar=new Button("Cancelar",event-> new UI().navigate("/"))


        );

        this.enderecoCadastro.add(new CadastroEndereco(enderecos, enderecoCadastro));


    }

}