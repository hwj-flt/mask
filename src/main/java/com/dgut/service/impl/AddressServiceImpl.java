package com.dgut.service.impl;

import com.dgut.domain.Address;
import com.dgut.mapper.AddressMapper;
import com.dgut.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("addressService")
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;
    @Override
    public List<Address> showAddress(String userId) {
        return addressMapper.showAddress(userId);
    }

    @Override
    public Address showaddByid(String id) {
        return addressMapper.showaddByid(id);
    }

    @Override
    public void delAddress(String id) {
        addressMapper.delAddress(id);
    }

    @Override
    public int updateAddress(Address address) {
        return addressMapper.updateAddress(address);
    }

    @Override
    public int addAddress(Address address) {
        return addressMapper.addAddress(address);
    }
}
