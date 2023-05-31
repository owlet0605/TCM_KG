package com.example.tcm_kgsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tcm {
    private Long tcmId;

    private String tcmNameZh;

    private String tcmNameEn;

    private String tcmPinyin;

    private String tcmInductive;

    private String tcmTaste;

    private String tcmAlias;
}