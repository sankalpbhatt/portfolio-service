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
        switch (nameFilter.getOperation()) {
          case CONTAINS:
            predicate =
                builder.and(
                    predicate,
                    builder.like(
                        root.get("name"), "%" + nameFilter.getValue().toLowerCase() + "%"));
            break;
          case EQUALS:
            predicate =
                builder.and(
                    predicate,
                    builder.equal(
                        builder.lower(root.get("name")), nameFilter.getValue().toLowerCase()));
            break;
          case STARTS_WITH:
            predicate =
                builder.and(
                    predicate,
                    builder.like(
                        builder.lower(root.get("name")),
                        nameFilter.getValue().toLowerCase() + "%"));
            break;
          case ENDS_WITH:
            predicate =
                builder.and(
                    predicate,
                    builder.like(
                        builder.lower(root.get("name")),
                        "%" + nameFilter.getValue().toLowerCase()));
            break;
        }
      }
      return predicate;
    };
  }
}
