package com.quiz.quiz;

import com.quiz.quiz.bs.dao.EmpleadoRepository;
import com.quiz.quiz.bs.services.EmpleadoService;
import com.quiz.quiz.eis.bo.Empleado;
import com.quiz.quiz.util.ValidatePassword;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpleadoRepositoryTest {

    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private EmpleadoService empleadoService;

    @Test
    public void findEmpleadoById() {
        Optional found = this.empleadoRepository.findById(1);
        if (found.isPresent()) {
            Empleado empleado = (Empleado) found.get();
            System.out.println(empleado.getNombre());
        }
    }

    @Test
    public void filterEmpleados() {
        List<Empleado> empleados = this.empleadoService.filterEmpleado("ner");
        for (Empleado e : empleados) {
            System.out.println("====> " + e.getNombre());
        }
    }

    @Test
    public void testValidationFunction() {
        ValidatePassword.isValid("Mdef%3M");
    }

}
