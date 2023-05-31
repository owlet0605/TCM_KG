package com.example.tcm_kgsystem.mapper;

import com.example.tcm_kgsystem.entity.ArticleType;
import com.example.tcm_kgsystem.entity.ArticleTypeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ArticleTypeMapper {
    int countByExample(ArticleTypeExample example);

    int deleteByExample(ArticleTypeExample example);

    int deleteByPrimaryKey(Long articleTypeId);

    int insert(ArticleType record);

    int insertSelective(ArticleType record);

    List<ArticleType> selectByExampleWithBLOBs(ArticleTypeExample example);

    List<ArticleType> selectByExample(ArticleTypeExample example);

    ArticleType selectByPrimaryKey(Long articleTypeId);

    int updateByExampleSelective(@Param("record") ArticleType record, @Param("example") ArticleTypeExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticleType record, @Param("example") ArticleTypeExample example);

    int updateByExample(@Param("record") ArticleType record, @Param("example") ArticleTypeExample example);

    int updateByPrimaryKeySelective(ArticleType record);

    int updateByPrimaryKeyWithBLOBs(ArticleType record);

    int updateByPrimaryKey(ArticleType record);
}