/**
 * Placeholder for Licence information
 */

package com.portfolio.portfolioservice.userinfo.entity.speicification;

import java.util.Objects;

import org.springframework.data.jpa.domain.Specification;

import com.portfolio.portfolioservice.common.model.request.StringFilter;
import com.portfolio.portfolioservice.userinfo.entity.UserInfo;
import com.portfolio.portfolioservice.userinfo.model.request.UserInfoSearchCriteria;

import jakarta.persistence.criteria.Predicate;

public class UserInfoSpecification {

  public static Specification<UserInfo> getUserInfoBySpecification(
      UserInfoSearchCriteria searchCriteria) {
    return (root, query, builder) -> {
      Predicate predicate = builder.conjunction();
      StringFilter nameFilter = searchCriteria.getName();
      if (Objects.nonNull(nameFilter)) {
        switch (nameFilter.getOperation()) {
          case EQUALS -> {
            Predicate firstName =
                builder.equal(builder.lower(root.get("firstName")), nameFilter.getValue());
            Predicate lastName =
                builder.equal(builder.lower(root.get("lastName")), nameFilter.getValue());
            predicate = builder.or(firstName, lastName);
          }
          case CONTAINS -> {
            Predicate firstName =
                builder.like(
                    builder.lower(root.get("firstName")), "%" + nameFilter.getValue() + "%");
            Predicate lastName =
                builder.like(
                    builder.lower(root.get("lastName")), "%" + nameFilter.getValue() + "%");
            predicate = builder.or(firstName, lastName);
          }
          case STARTS_WITH -> {
            Predicate firstName =
                builder.like(builder.lower(root.get("firstName")), nameFilter.getValue() + "%");
            Predicate lastName =
                builder.like(builder.lower(root.get("lastName")), nameFilter.getValue() + "%");
            predicate = builder.or(firstName, lastName);
          }
          case ENDS_WITH -> {
            Predicate firstName =
                builder.like(builder.lower(root.get("firstName")), "%" + nameFilter.getValue());
            Predicate lastName =
                builder.like(builder.lower(root.get("lastName")), "%" + nameFilter.getValue());
            predicate = builder.or(firstName, lastName);
          }
        }
      }
      return predicate;
    };
  }
}
