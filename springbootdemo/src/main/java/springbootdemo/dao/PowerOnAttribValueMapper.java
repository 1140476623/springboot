package springbootdemo.dao;

import java.util.List;

import com.github.pagehelper.Page;

import springbootdemo.pojo.PowerOnAttribValue;

public interface PowerOnAttribValueMapper {
    int insert(PowerOnAttribValue record);

    int insertSelective(PowerOnAttribValue record);

    List<PowerOnAttribValue> findAll();

    Page<PowerOnAttribValue> findPage();

}