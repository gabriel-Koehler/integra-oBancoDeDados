package net.weg.api.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import net.weg.api.model.Carro;
import net.weg.api.model.DTO.CarroCadastroDTO;
import net.weg.api.service.CarroService;
import org.springframework.beans.BeanUtils;

public class CadastroCarro extends FormLayout {
    private final CarroService carroService;
    public CadastroCarro(CarroService carroService, Dialog dialog){
        this.carroService=carroService;
        TextField placa = new TextField("Placa");
        TextField modelo = new TextField("Modelo");
        TextField cor = new TextField("Cor");
        TextField marca = new TextField("Marca");
        NumberField ano =new NumberField("Ano");
        NumberField preco =new NumberField("Preco");
        Button salvar = new Button("Salvar", new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                preco.getValue();
                CarroCadastroDTO carroCadastroDTO=
                        new CarroCadastroDTO(
                                marca.getValue(),
                                cor.getValue(),
                                placa.getValue(),
                                modelo.getValue(),
                                preco.getValue(),
                                ano.getValue().intValue()
                        );
                Carro carro=new Carro();
                BeanUtils.copyProperties(carroCadastroDTO,carro);
                carroService.salvar(carro);
                dialog.close();
            }
        });

        Button cancelar = new Button("Cancelar", e -> dialog.close());
        add(placa, modelo, cor, marca,
                ano,preco,salvar,cancelar);
    }
}
