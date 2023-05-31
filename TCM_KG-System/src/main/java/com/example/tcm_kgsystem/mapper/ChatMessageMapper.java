package com.example.tcm_kgsystem.mapper;

import com.example.tcm_kgsystem.entity.ChatMessage;
import com.example.tcm_kgsystem.entity.ChatMessageExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ChatMessageMapper {
    int countByExample(ChatMessageExample example);

    int deleteByExample(ChatMessageExample example);

    int deleteByPrimaryKey(Long chatMessageId);

    int insert(ChatMessage record);

    int insertSelective(ChatMessage record);

    List<ChatMessage> selectByExample(ChatMessageExample example);

    ChatMessage selectByPrimaryKey(Long chatMessageId);

    int updateByExampleSelective(@Param("record") ChatMessage record, @Param("example") ChatMessageExample example);

    int updateByExample(@Param("record") ChatMessage record, @Param("example") ChatMessageExample example);

    int updateByPrimaryKeySelective(ChatMessage record);

    int updateByPrimaryKey(ChatMessage record);
}