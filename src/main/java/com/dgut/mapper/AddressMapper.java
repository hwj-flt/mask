package com.dgut.mapper;

import com.dgut.domain.Address;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/*Select * From Table1 a
        Where Exists (
        Select * from Table1
        where id=a.id
        Group By ID*/
@Repository
public interface AddressMapper {
    @Select("SELECT * FROM address  WHERE user_id = #{userId}")
    public List<Address> showAddress(String userId);
    @Select("SELECT * FROM address  WHERE id = #{id}")
    public Address showaddByid(String id);
    @Delete("delete from address where id = #{id}")
    public void delAddress(String id);
    @Update("update address set addd=#{addd},full_add=#{full_add},name1=#{name1},phone=#{phone},provinceid=#{provinceid}," +
            "cityid=#{cityid},townid=#{townid} where id=#{id}")
    public int updateAddress(Address address);
    @Insert("insert into address(id,addd,full_add,user_id,name1,phone,provinceid,cityid,townid) value(#{id},#{addd},#{full_add}," +
            "#{user_id},#{name1},#{phone},#{provinceid},#{cityid},#{townid})")
    public int addAddress(Address address);
}
