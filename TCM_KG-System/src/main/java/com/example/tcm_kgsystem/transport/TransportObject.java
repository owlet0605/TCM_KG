package com.example.tcm_kgsystem.transport;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransportObject {
    private int code;
    private String msg;
    private Object object;
}
