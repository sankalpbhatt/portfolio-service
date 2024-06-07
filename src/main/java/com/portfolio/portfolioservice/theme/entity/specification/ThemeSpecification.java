package com.portfolio.portfolioservice.theme.entity.specification;

import com.portfolio.portfolioservice.common.model.request.StringFilter;
import com.portfolio.portfolioservice.theme.entity.Theme;
import com.portfolio.portfolioservice.theme.model.request.ThemeSearchCriteria;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;


public class ThemeSpecification {

    public static Specification<Theme> getThemesBySpecifications(ThemeSearchCriteria searchCriteria) {
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();
            if (Objects.nonNull(searchCriteria.getName())) {
                StringFilter nameFilter = searchCriteria.getName();
                switch (nameFilter.getOperation()) {
                    case CONTAINS:
                        predicate = builder.and(predicate, builder.like(root.get("name"), "%" + nameFilter.getValue() + "%"));
                        break;
                    case EQUALS:
                        builder.and(predicate, builder.equal(root.get("name"), nameFilter.getValue()));
                        break;
                    case STARTS_WITH:
                        builder.and(predicate, builder.like(root.get("name"), nameFilter.getValue() + "%"));
                        break;
                    case ENDS_WITH:
                        builder.and(predicate, builder.like(root.get("name"), "%" + nameFilter.getValue()));
                        break;
                }

            }
            return predicate;
        };
    }
}
