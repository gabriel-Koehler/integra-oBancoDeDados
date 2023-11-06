package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.Seguro;
import net.weg.api.service.CarroService;
import net.weg.api.service.ClienteService;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;

@Route(value ="/meus-seguros",layout = NavBarApp.class)
public class MeusSeguros extends VerticalLayout {
    public MeusSeguros(SeguradoraService seguradoraService,
                       CarroService carroService,
                       ClienteService clienteService,
                       SeguroService seguroService){
        HorizontalLayout hl=new HorizontalLayout();
        hl.add(new H1("Meus Seguros"));
        Dialog cadastroSeguro =new Dialog();
        cadastroSeguro.add(new CadastroSeguro(seguradoraService,carroService,clienteService,cadastroSeguro,seguroService));
        hl.add(new Button("Novo Seguro",e->cadastroSeguro.open()));
        add(hl);
        Grid<Seguro> seguros= new Grid<>(Seguro.class);
        add(seguros);
    }

}
