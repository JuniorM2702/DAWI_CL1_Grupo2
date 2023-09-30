package pe.edu.cibertec.DAWI_CL1_Grupo2.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pregunta1Model {

    private Double precio;
    private Integer cantidad;
    private Double descuento;


    public Double getPrecio() {
        return precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }
}
