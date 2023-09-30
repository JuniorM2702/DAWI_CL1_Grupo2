package pe.edu.cibertec.DAWI_CL1_Grupo2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_Grupo2.model.Pregunta4Model;
import java.util.ArrayList;
import java.util.List;


@Controller
public class Pregunta4Controller {

    @GetMapping("/pregunta4")
    public String index(Model model) {
        model.addAttribute("pregunta4model", new Pregunta4Model());
        model.addAttribute("verresultados", false);

        return "formpregunta4";
    }

    @PostMapping("/pregunta4")
    public String calcularNumero(@ModelAttribute("pregunta4model") Pregunta4Model pregunta4model, Model model)
    {
        Integer limite = pregunta4model.getLimite();
        model.addAttribute("pregunta4model", pregunta4model);

        List<String> resultados = new ArrayList<>();

        for (Integer i = 1; i <= limite; i++) {
            Integer cubo = calcularCubo(i);
            Integer cuarta = calcularCuarta(i);

            resultados.add("Número: " + i + ", Cubo: " + cubo + ", Cuarta: " + cuarta);
        }

        model.addAttribute("verresultados", true);
        model.addAttribute("resultados", resultados);
        return "formpregunta4";
    }

    private Integer calcularCubo(Integer num) {
        return num * num * num;
    }

    private Integer calcularCuarta(Integer num) {
        return num * num * num * num;
    }
}




