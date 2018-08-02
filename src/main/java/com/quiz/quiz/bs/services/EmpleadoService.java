package com.quiz.quiz.bs.services;

import com.quiz.quiz.bs.dao.EmpleadoRepository;
import com.quiz.quiz.eis.bo.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private EntityManager em;

    public void addEmployee(Empleado empleado) {
        if (empleado != null) {
            this.empleadoRepository.saveAndFlush(empleado);
        }
    }

    public void updateEmployee(Empleado empleado) {
        if (empleado != null) {
            this.empleadoRepository.saveAndFlush(empleado);
        }
    }

    public void deleteEmployee(Integer idEmployee) {
        Optional<Empleado> found = this.empleadoRepository.findById(idEmployee);
        found.ifPresent(empleado -> this.empleadoRepository.delete(empleado));
    }

    public Empleado findEmpleado(Integer idEmployee) {
        Optional<Empleado> found = this.empleadoRepository.findById(idEmployee);
        return found.orElse(null);
    }

    public List<Empleado> filterEmpleado(String param) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Empleado> query = cb.createQuery(Empleado.class);
        Root<Empleado> empleadoRoot = query.from(Empleado.class);
        query.where(
                cb.like(
                        empleadoRoot.get("nombre"),
                        cb.parameter(String.class, "likeCondition")
                )
        );

        TypedQuery<Empleado> tq = em.createQuery(query);
        tq.setParameter("likeCondition", "%" + param + "%");
        return tq.getResultList();
    }
}
