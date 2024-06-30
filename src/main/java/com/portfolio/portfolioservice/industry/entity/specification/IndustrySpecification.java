/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.industry.entity.specification;

import org.springframework.data.jpa.domain.Specification;

import com.portfolio.portfolioservice.common.model.request.StringFilter;
import com.portfolio.portfolioservice.industry.entity.Industry;
import com.portfolio.portfolioservice.industry.model.request.IndustrySearchCriteria;

import jakarta.persistence.criteria.Predicate;

public class IndustrySpecification {

  public static Specification<Industry> getIndustriesByCriteria(IndustrySearchCriteria criteria) {
    return (root, query, builder) -> {
      Predicate predicate = builder.conjunction();

      if (criteria.getName() != null) {
        StringFilter nameFilter = criteria.getName();
        predicate =
            switch (nameFilter.getOperation()) {
              case CONTAINS ->
                  builder.and(
                      predicate,
                      builder.like(root.get("industryName"), "%" + nameFilter.getValue() + "%"));
              case EQUALS ->
                  builder.and(
                      predicate, builder.equal(root.get("industryName"), nameFilter.getValue()));
              case STARTS_WITH ->
                  builder.and(
                      predicate,
                      builder.like(root.get("industryName"), nameFilter.getValue() + "%"));
              case ENDS_WITH ->
                  builder.and(
                      predicate,
                      builder.like(root.get("industryName"), "%" + nameFilter.getValue()));
            };
      }
      return predicate;
    };
  }
}
