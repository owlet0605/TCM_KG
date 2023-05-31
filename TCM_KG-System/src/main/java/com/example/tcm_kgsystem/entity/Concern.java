package com.example.tcm_kgsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Concern {
    private Long concernId;

    private Long concernUserId;

    private Long concernedUserId;
}