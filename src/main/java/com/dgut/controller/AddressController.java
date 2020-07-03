package com.dgut.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dgut.common.Result;
import com.dgut.common.ResultStatus;
import com.dgut.common.Uuid;
import com.dgut.domain.Address;
import com.dgut.domain.Vo.UserVo;
import com.dgut.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/add")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/showadd")
    @ResponseBody
    @CrossOrigin
    public Result showadd(@RequestBody UserVo userVo){
        String userId=userVo.getId();
        List<Address> a = addressService.showAddress(userId);
        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(a);
        return new Result(ResultStatus.SUCCESS,jsonArray);
    }
    @PostMapping("/addByid")
    @ResponseBody
    @CrossOrigin
    public Result showaddByid(@RequestBody Address address){
        Address a = addressService.showaddByid(address.getId());
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(a);
        return new Result(ResultStatus.SUCCESS,jsonObject);
    }
    @PostMapping("/insert")
    @ResponseBody
    @CrossOrigin
    public Result insert(@RequestBody Address address){
        address.setId(Uuid.getUUid());
        int num=addressService.addAddress(address);
        return new Result(ResultStatus.SUCCESS);
    }
    @PostMapping(value = "/updateAdd")
    @ResponseBody
    @CrossOrigin
    public Result updateAdd(@RequestBody Address address){
        System.out.println(address);
        addressService.updateAddress(address);
        return new Result(ResultStatus.SUCCESS);
    }
    @RequestMapping(value = "/delAdd")
    @ResponseBody
    @CrossOrigin
    public void delAdd(@RequestBody Address address){
        addressService.delAddress(address.getId());
    }
}
