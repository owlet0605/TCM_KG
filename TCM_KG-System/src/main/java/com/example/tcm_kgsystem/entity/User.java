package com.example.tcm_kgsystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;

    private String userName;

    private String userPassword;

    private String userSex;

    private String userEmail;

    private String userPhone;

    private Integer userStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date userBirthday;

    private String userImg;

    private Integer userFans;

    private Integer userConcern;

    private Integer userLike;

    private Integer userView;

    private Integer userSecurity;

    private String userToken;

}