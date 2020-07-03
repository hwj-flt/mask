package com.dgut.service;

import com.dgut.domain.Address;

import java.util.List;

public interface AddressService {
    public List<Address> showAddress(String userId);
    public Address showaddByid(String id);
    public void delAddress(String id);
    public int updateAddress(Address address);
    public int addAddress(Address address);
}
