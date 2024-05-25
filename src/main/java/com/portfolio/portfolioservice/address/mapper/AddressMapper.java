package com.portfolio.portfolioservice.address.mapper;

import com.portfolio.portfolioservice.address.entity.Address;
import com.portfolio.portfolioservice.address.model.request.AddressRequest;
import com.portfolio.portfolioservice.address.model.response.AddressResponse;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AddressMapper {

    public Address mapToEntity(AddressRequest addressRequest){
        Address address = new Address();
        address.setAddressLine1(addressRequest.getAddressLine1());
        address.setAddressLine2(addressRequest.getAddressLine2());
        address.setCity(addressRequest.getCity());
        address.setRegion(addressRequest.getRegion());
        address.setCountry(addressRequest.getCountry());
        address.setPostalCode(addressRequest.getPostalCode());
        return address;
    }

    public Set<Address> mapToEntity(List<AddressRequest> addressRequests){
        Set<Address> addresses = new HashSet<>();
        addressRequests.stream().map(address -> this.mapToEntity(address)).collect(Collectors.toSet());
        return addresses;
    }

    public AddressResponse mapToResponse(Address address) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(address.getSerialId());
        addressResponse.setAddressLine1(address.getAddressLine1());
        addressResponse.setAddressLine2(address.getAddressLine2());
        addressResponse.setCity(address.getCity());
        addressResponse.setRegion(address.getRegion());
        addressResponse.setCountry(address.getCountry());
        addressResponse.setPostalCode(address.getPostalCode());
        return addressResponse;
    }

    public Set<AddressResponse> mapToResponse(Set<Address> addresses) {
        return addresses.stream().map(address -> this.mapToResponse(address)).collect(Collectors.toSet());
    }
}
