package com.zenvia.newhorizon.agendabot.repository;

import com.zenvia.newhorizon.agendabot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
