package com.quiz.quiz.bs.dao;

import com.quiz.quiz.eis.bo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
