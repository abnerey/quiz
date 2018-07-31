import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import java.math.BigDecimal;

@Table()
public class Empleado {

    private Integer id;
    private String nombre;
    private BigDecimal salario;
    private Date creacion;

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private getId() {
        return this.id;
    }

}