package com.example.tcm_kgsystem.mapper;

import com.example.tcm_kgsystem.entity.ChatLink;
import com.example.tcm_kgsystem.entity.ChatLinkExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ChatLinkMapper {
    int countByExample(ChatLinkExample example);

    int deleteByExample(ChatLinkExample example);

    int deleteByPrimaryKey(Long chatLinkId);

    int insert(ChatLink record);

    int insertSelective(ChatLink record);

    List<ChatLink> selectByExample(ChatLinkExample example);

    ChatLink selectByPrimaryKey(Long chatLinkId);

    int updateByExampleSelective(@Param("record") ChatLink record, @Param("example") ChatLinkExample example);

    int updateByExample(@Param("record") ChatLink record, @Param("example") ChatLinkExample example);

    int updateByPrimaryKeySelective(ChatLink record);

    int updateByPrimaryKey(ChatLink record);
}