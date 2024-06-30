/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.role.entity.sepcification;

import org.springframework.data.jpa.domain.Specification;

import com.portfolio.portfolioservice.common.model.request.StringFilter;
import com.portfolio.portfolioservice.role.entity.Role;
import com.portfolio.portfolioservice.role.model.request.RoleSearchCriteria;

import jakarta.persistence.criteria.Predicate;

public class RoleSpecification {

  public static Specification<Role> getRoleByCriteria(RoleSearchCriteria searchCriteria) {
    return (root, query, builder) -> {
      Predicate predicate = builder.conjunction();
      StringFilter name = searchCriteria.getName();
      switch (name.getOperation()) {
        case EQUALS ->
            predicate =
                builder.and(
                    predicate, builder.equal(builder.lower(root.get("name")), name.getValue()));
        case CONTAINS ->
            predicate =
                builder.and(
                    predicate,
                    builder.like(builder.lower(root.get("name")), "%" + name.getValue() + "%"));
        case STARTS_WITH ->
            predicate =
                builder.and(
                    predicate,
                    builder.like(builder.lower(root.get("name")), "%" + name.getValue()));
        case ENDS_WITH ->
            predicate =
                builder.and(
                    predicate,
                    builder.like(builder.lower(root.get("name")), name.getValue() + "%"));
      }
      return predicate;
    };
  }
}
