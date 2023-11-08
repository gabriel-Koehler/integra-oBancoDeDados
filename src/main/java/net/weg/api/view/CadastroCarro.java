package net.weg.api.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.service.CarroService;


public class CadastroCarro extends Dialog {

    private TextField placa = new TextField("placa");
    private TextField marca = new TextField("marca");
    private TextField cor = new TextField("cor");
    private TextField modelo = new TextField("modelo");
    private IntegerField ano = new IntegerField("ano");
    private NumberField preco = new NumberField("preço");

    private FormLayout formLayout = new FormLayout();

    private final CarroService carroService;
    CadastroCarro( CarroService carroService) {
        this.carroService = carroService;

        Button salvar = new Button("Salvar", new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                CarroCadastroDTO carroCadastroDTO = new CarroCadastroDTO(placa.getValue(),marca.getValue(),cor.getValue(),modelo.getValue()
                ,preco.getValue(),ano.getValue());
                try {
                    carroService.cadastrar(carroCadastroDTO);
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
                close();
            }
        });
        Button cancelar = new Button("Cancelar", e -> this.close());
        this.getFooter().add(cancelar, salvar);
        formLayout.add(placa, marca, cor, modelo, ano, preco);
        this.add(formLayout);
    }
}
