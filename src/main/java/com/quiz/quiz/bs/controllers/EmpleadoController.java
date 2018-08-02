package com.quiz.quiz.bs.controllers;

import com.quiz.quiz.bs.services.EmpleadoService;
import com.quiz.quiz.eis.bo.Empleado;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/empleados", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Empleado findEmployee(@PathVariable("id") Integer id) {
        try {
            return this.empleadoService.findEmpleado(id);
        } catch(ServiceException se) {
            se.printStackTrace();
            throw se;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable("id") Integer id) {
        try {
            this.empleadoService.deleteEmployee(id);
        } catch(ServiceException se) {
            se.printStackTrace();
            throw se;
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateEmployee(@RequestBody Empleado empleado) {
        try {
            this.empleadoService.updateEmployee(empleado);
        } catch(ServiceException se) {
            se.printStackTrace();
            throw se;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public void saveEmployee(@RequestBody Empleado empleado) {
        try {
            this.empleadoService.addEmployee(empleado);
        } catch(ServiceException se) {
            se.printStackTrace();
            throw se;
        }
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public List<Empleado> getFilterEmployees(@RequestParam(value = "param") String filterParam) {
        try {
            System.out.println("param: " + filterParam);
            return this.empleadoService.filterEmpleado(filterParam);
        } catch(ServiceException se) {
            se.printStackTrace();
            throw se;
        }
    }
}
