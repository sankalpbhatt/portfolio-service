package com.portfolio.portfolioservice.address.mapper;

import com.portfolio.portfolioservice.address.entity.Address;
import com.portfolio.portfolioservice.address.model.request.AddressRequest;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address mapToEntity(AddressRequest addressRequest){
        return new Address();
    }
}
