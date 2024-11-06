package com.ajaysw.service;

import com.ajaysw.model.User;
import com.ajaysw.payload.AddressDTO;

import java.util.List;

public interface AddressService {
    AddressDTO createAddress(AddressDTO addressDTO, User user);

    List<AddressDTO> getAddresses();

    AddressDTO getAddressById(Long addressId);

    List<AddressDTO> getUserAddresses(User user);

    AddressDTO updateAddress(Long addressId,AddressDTO addressDTO);

    String deleteAddress(Long addressId);
}