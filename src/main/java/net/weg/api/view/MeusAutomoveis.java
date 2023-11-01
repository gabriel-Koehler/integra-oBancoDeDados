package net.weg.api.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.dialog.Dialog;
import lombok.Data;
import net.weg.api.model.Carro;
import net.weg.api.model.Seguro;
import net.weg.api.service.CarroService;

import java.awt.*;

@Route(value ="/meus-automoveis", layout=NavBarApp.class)
public class MeusAutomoveis extends VerticalLayout {
    private  final  CarroService carroService;
    public MeusAutomoveis(CarroService carroService){
        this.carroService=carroService;
        HorizontalLayout hl=new HorizontalLayout();
        Dialog cadastro = new Dialog();
        cadastro.add(new CadastroCarro(carroService,cadastro));
        hl.add(new H1("Meus Automóveis"));

        hl.add(new Button("Novo Carro", e->cadastro.open()));

        add(hl);
        Grid<Carro> grid = new Grid<>(Carro.class);
        grid.setItems(carroService.buscarTodos());
        add(grid);
    }

}
