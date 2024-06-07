package com.portfolio.portfolioservice.industry.entity.specification;

import com.portfolio.portfolioservice.common.model.request.StringFilter;
import com.portfolio.portfolioservice.industry.entity.Industry;
import com.portfolio.portfolioservice.industry.model.request.IndustrySearchCriteria;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class IndustrySpecification {

    public static Specification<Industry> getIndustriesByCriteria(IndustrySearchCriteria criteria) {
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();

            if (criteria.getName() != null) {
                StringFilter nameFilter = criteria.getName();
                switch (nameFilter.getOperation()) {
                    case CONTAINS:
                        predicate = builder.and(predicate, builder.like(root.get("industryName"), "%" + nameFilter.getValue() + "%"));
                        break;
                    case EQUALS:
                        predicate = builder.and(predicate, builder.equal(root.get("industryName"), nameFilter.getValue()));
                        break;
                    case STARTS_WITH:
                        predicate = builder.and(predicate, builder.like(root.get("industryName"), nameFilter.getValue() + "%"));
                        break;
                    case ENDS_WITH:
                        predicate = builder.and(predicate, builder.like(root.get("industryName"), "%" + nameFilter.getValue()));
                        break;
                }
            }
            return predicate;
        };
    }
}
