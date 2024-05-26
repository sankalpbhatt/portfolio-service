package com.portfolio.portfolioservice.template.repository;


import com.portfolio.portfolioservice.template.enitity.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TemplateRepository extends JpaRepository<Template, UUID> {

    Optional<Template> findBySerialId(String id);
}
