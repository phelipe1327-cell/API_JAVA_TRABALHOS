package org.serratec.aula03.repository;

import org.serratec.aula03.domain.ClientePremium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientePremiumRepository extends JpaRepository<ClientePremium, Long> {
}