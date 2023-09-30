package pe.edu.cibertec.DAWI_CL1_Grupo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_Grupo2.model.Pregunta2Model;

@Controller
public class FormPregunta2Controller {

    @GetMapping ("/calcularpres")
    public String index(Model model){
        model.addAttribute("calcular", new Pregunta2Model());
        model.addAttribute("verResultado", false);
        return "formcalcular";
    }
    @PostMapping("/calcularpres")
    public String calcularpres(@ModelAttribute ("calcular") Pregunta2Model pregunta2Model, Model model){
        Double montoPrestamo = pregunta2Model.getMonto();
        Integer  numeroCuotas;
        Double montoCuota;
        Double interes;

        if (montoPrestamo > 5000) {
            numeroCuotas = 3;
        } else if (montoPrestamo < 1000) {
            numeroCuotas = 1;
        } else if (montoPrestamo >= 2000 && montoPrestamo <= 3000) {
            numeroCuotas = 2;
        } else {
            numeroCuotas = 5;
        }

        if (montoPrestamo < 4000) {
            interes = 0.12;
        } else {
            interes = 0.10;
        }
        montoCuota = (montoPrestamo * (1 + interes)) / numeroCuotas;

        model.addAttribute("verresultado", true);
        model.addAttribute("resultado","Su valor de prestamo: " +
                String.format("%.2f", montoPrestamo) + ", usted se encuentra: " + numeroCuotas + ", usted entrà un interes de: " + interes);
        return "formcalcular";
    }
}

