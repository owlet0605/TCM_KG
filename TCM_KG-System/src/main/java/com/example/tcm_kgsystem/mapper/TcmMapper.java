package com.example.tcm_kgsystem.mapper;

import com.example.tcm_kgsystem.entity.Tcm;
import com.example.tcm_kgsystem.entity.TcmExample;
import com.example.tcm_kgsystem.entity.TcmWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TcmMapper {
    int countByExample(TcmExample example);

    int deleteByExample(TcmExample example);

    int deleteByPrimaryKey(Long tcmId);

    int insert(TcmWithBLOBs record);

    int insertSelective(TcmWithBLOBs record);

    List<TcmWithBLOBs> selectByExampleWithBLOBs(TcmExample example);

    List<Tcm> selectByExample(TcmExample example);

    TcmWithBLOBs selectByPrimaryKey(Long tcmId);

    int updateByExampleSelective(@Param("record") TcmWithBLOBs record, @Param("example") TcmExample example);

    int updateByExampleWithBLOBs(@Param("record") TcmWithBLOBs record, @Param("example") TcmExample example);

    int updateByExample(@Param("record") Tcm record, @Param("example") TcmExample example);

    int updateByPrimaryKeySelective(TcmWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TcmWithBLOBs record);

    int updateByPrimaryKey(Tcm record);
}