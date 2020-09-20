package com.zenvia.newhorizon.agendabot.repository;

import com.zenvia.newhorizon.agendabot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
