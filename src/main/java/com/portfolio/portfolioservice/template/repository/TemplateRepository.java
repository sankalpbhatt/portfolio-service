/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.template.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.portfolioservice.template.enitity.Template;

public interface TemplateRepository extends JpaRepository<Template, UUID> {

  Optional<Template> findBySerialId(String id);
}
