package pe.edu.cibertec.DAWI_CL1_Grupo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_Grupo2.model.Pregunta1Model;

@Controller
public class FormPregunta1Controller {
    @GetMapping("/pregunta1")
    public String index(Model model){
        model.addAttribute("pregunta1model", new Pregunta1Model());
        model.addAttribute("verresultado", false);

        return "formpregunta1";
    }

    @PostMapping("/pregunta1")
    public String calculardescuento(
            @ModelAttribute("pregunta1") Pregunta1Model pregunta1model, Model model){
        Double valorTotal = pregunta1model.getPrecio() * pregunta1model.getCantidad();

        if(valorTotal > 200){
            valorTotal *= 0.8;
        }

        model.addAttribute("verresultado", true);
        model.addAttribute("resultado", "El valor total a pagar es: $" + valorTotal);


        return "formpregunta1";


    }

}
