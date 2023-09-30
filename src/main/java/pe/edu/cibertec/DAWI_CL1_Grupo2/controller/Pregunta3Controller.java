package pe.edu.cibertec.DAWI_CL1_Grupo2.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Pregunta3Controller {

    @GetMapping("/convertirAVocal")
    public String mostrarFormulario() {
        return "formpregunta3";
    }

    @PostMapping("/convertirAVocal")
    @ResponseBody
    public String convertirAVocal(@RequestParam int numero) {
        String vocal = obtenerVocal(numero);
        return "La vocal correspondiente al número " + numero + " es: " + vocal;
    }

    private String obtenerVocal(int numero) {
        switch (numero) {
            case 1:
                return "A";
            case 2:
                return "E";
            case 3:
                return "I";
            case 4:
                return "O";
            case 5:
                return "U";
            default:
                return "No se encontró una vocal correspondiente.";
        }
    }
}