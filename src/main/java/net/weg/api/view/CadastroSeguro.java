package net.weg.api.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import net.weg.api.model.Carro;
import net.weg.api.model.Cliente;
import net.weg.api.model.DTO.CarroCadastroDTO;
import net.weg.api.model.DTO.SeguroCadastroDTO;
import net.weg.api.model.Seguradora;
import net.weg.api.model.Seguro;
import net.weg.api.service.CarroService;
import net.weg.api.service.ClienteService;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;
import org.springframework.beans.BeanUtils;

public class CadastroSeguro extends FormLayout {
    private SeguroService seguroService;
    CadastroSeguro(SeguradoraService seguradoraService,
                   CarroService carroService,
                   ClienteService clienteService,
                   Dialog dialog,
                   SeguroService seguroService) {
        this.seguroService=seguroService;
        NumberField valor= new NumberField("Valor");
        TextField descricao= new TextField("Descrição");
        NumberField valorFranquia=new NumberField("Valor da Franquia");
        Select<Seguradora> seguradora=new Select<>();
        seguradora.setLabel("Seguradora");
        seguradora.setItems(seguradoraService.buscarTodos());
        Select<Carro> carro=new Select<>();
        carro.setLabel("Carro");
        carro.setItems(carroService.buscarTodos());
        Select<Cliente> cliente=new Select<>();
        cliente.setLabel("Cliente");
        cliente.setItems(clienteService.buscarTodos());
        Button salvar = new Button("Salvar", new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {

                SeguroCadastroDTO seguroCadastroDTO=
                        new SeguroCadastroDTO(
                                valor.getValue(),
                                descricao.getValue(),
                                valorFranquia.getValue(),
                                seguradora.getValue(),
                                carro.getValue(),
                                cliente.getValue()
                        );
                Seguro seguro=new Seguro();
                seguroService.salvar(seguro);
                dialog.close();
            }
        });

        Button cancelar = new Button("Cancelar", e -> dialog.close());

        add(valor,valorFranquia,carro,seguradora,cliente,descricao);

    }
}
