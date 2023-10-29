package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SetmealService {
    PageResult page(SetmealPageQueryDTO setmealPageQueryDTO);


    void saveWithDish(SetmealDTO setmealDTO);

    SetmealVO getByIdwithDish(Long id);

    void update(SetmealDTO setmealDTO);

    void delete(List<Long> ids);
}
