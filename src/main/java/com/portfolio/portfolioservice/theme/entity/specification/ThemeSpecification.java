/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.theme.entity.specification;

import java.util.Objects;

import org.springframework.data.jpa.domain.Specification;

import com.portfolio.portfolioservice.common.model.request.StringFilter;
import com.portfolio.portfolioservice.theme.entity.Theme;
import com.portfolio.portfolioservice.theme.model.request.ThemeSearchCriteria;

import jakarta.persistence.criteria.Predicate;

public class ThemeSpecification {

  public static Specification<Theme> getThemesBySpecifications(ThemeSearchCriteria searchCriteria) {
    return (root, query, builder) -> {
      Predicate predicate = builder.conjunction();
      if (Objects.nonNull(searchCriteria.getName())) {
        StringFilter nameFilter = searchCriteria.getName();
        predicate =
            switch (nameFilter.getOperation()) {
              case CONTAINS ->
                  builder.and(
                      predicate,
                      builder.like(
                          root.get("name"), "%" + nameFilter.getValue().toLowerCase() + "%"));
              case EQUALS ->
                  builder.and(
                      predicate,
                      builder.equal(
                          builder.lower(root.get("name")), nameFilter.getValue().toLowerCase()));
              case STARTS_WITH ->
                  builder.and(
                      predicate,
                      builder.like(
                          builder.lower(root.get("name")),
                          nameFilter.getValue().toLowerCase() + "%"));
              case ENDS_WITH ->
                  builder.and(
                      predicate,
                      builder.like(
                          builder.lower(root.get("name")),
                          "%" + nameFilter.getValue().toLowerCase()));
            };
      }
      return predicate;
    };
  }
}
