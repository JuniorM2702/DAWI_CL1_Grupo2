package pe.edu.cibertec.DAWI_CL1_Grupo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String calcularDescuento(@ModelAttribute ("pregunta1model") Pregunta1Model pregunta1model, Model model) {
        Double precio = pregunta1model.getPrecio();
        Integer cantidad = pregunta1model.getCantidad();

        Double valorAPagar = precio * cantidad;
        if (valorAPagar >= 200) {
            valorAPagar *= 0.8;
        }

        model.addAttribute("verresultado", true);
        model.addAttribute("resultado", "El valor a pagar es: " + valorAPagar);


        return "formpregunta1";
    }
}
