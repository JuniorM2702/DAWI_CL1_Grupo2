package pe.edu.cibertec.DAWI_CL1_Grupo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_Grupo2.model.Pregunta5Model;

@Controller
public class FormPregunta5Controller {
    @GetMapping("/pregunta5")
    public String index(Model model){
        model.addAttribute("pregunta5model", new Pregunta5Model());
        model.addAttribute("verresultado", false);

        return "formpregunta5";
    }
    @PostMapping("/pregunta5")
    public String calcularDescuento(@ModelAttribute("pregunta5model") Pregunta5Model pregunta5model, Model model){
        Double precioTotal = pregunta5model.getPrecio() * pregunta5model.getCantidad();
        Double descuento = 0.0;

        if(pregunta5model.getCantidad()>20){
            descuento = precioTotal * 0.1;
        } else if(pregunta5model.getCantidad()>10){
            descuento = precioTotal * 0.05;
        }

        Double totalPagar = precioTotal - descuento;

        model.addAttribute("verresultado", true);
        model.addAttribute("resultado", "El valor a pagar es: " + totalPagar + " El descuento es: " + descuento);


        return "formpregunta5";
    }

}
