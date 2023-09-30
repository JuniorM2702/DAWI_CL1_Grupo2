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
        model.addAttribute("verresultado", false);

        return "formpregunta4";
    }

    @PostMapping("/pregunta4")
    public String calcularNumero(@ModelAttribute("pregunta4model") Pregunta4Model pregunta4model, Model model) {
        int limite = pregunta4model.getLimite();
        model.addAttribute("limite", limite);

        List<String> resultados = new ArrayList<>();

        for (int i = 1; i <= limite; i++) {
            int cubo = calcularCubo(i);
            int cuarta = calcularCuarta(i);

            resultados.add("Número: " + i + ", Cubo: " + cubo + ", Cuarta: " + cuarta);
        }

        model.addAttribute("verresultados", true);
        model.addAttribute("resultados", resultados);
        return "resultados";
    }

    private int calcularCubo(int num) {
        return num * num * num;
    }

    private int calcularCuarta(int num) {
        return num * num * num * num;
    }
}




