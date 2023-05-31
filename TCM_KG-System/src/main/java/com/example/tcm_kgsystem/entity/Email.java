package com.example.tcm_kgsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    private String userEmail;

    private String code;

    private Date setTime;

    private Date getTime;
}