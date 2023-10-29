package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SetmealMapper {

    /**
     * 根据分类id查询套餐的数量
     * @param id
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long id);


    Page<SetmealVO> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);


    void insert(SetmealDTO setmealDTO);

    @Select("select * from setmeal where id = #{id}")
    Setmeal getById(Long id);


    void update(Setmeal setmeal);

    @Delete("delete from setmeal where id = #{id}")
    void deleteById(Long setmealId);
}
