package com.example.tcm_kgsystem.mapper;

import com.example.tcm_kgsystem.entity.Result;
import com.example.tcm_kgsystem.entity.ResultExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ResultMapper {
    int countByExample(ResultExample example);

    int deleteByExample(ResultExample example);

    int deleteByPrimaryKey(Long resultId);

    int insert(Result record);

    int insertSelective(Result record);

    List<Result> selectByExampleWithBLOBs(ResultExample example);

    List<Result> selectByExample(ResultExample example);

    Result selectByPrimaryKey(Long resultId);

    int updateByExampleSelective(@Param("record") Result record, @Param("example") ResultExample example);

    int updateByExampleWithBLOBs(@Param("record") Result record, @Param("example") ResultExample example);

    int updateByExample(@Param("record") Result record, @Param("example") ResultExample example);

    int updateByPrimaryKeySelective(Result record);

    int updateByPrimaryKeyWithBLOBs(Result record);

    int updateByPrimaryKey(Result record);
}