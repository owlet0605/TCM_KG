package com.example.tcm_kgsystem.service.Util;

import java.util.Random;

public class CheckCodeBuilder {
    public static String creatCode() {
        String code = "";
        Random r = new Random();
        for (int i=0; i<6; i++) {
            int type = r.nextInt(3);
            switch (type) {
                case 0:
                    String ch = String.valueOf((char)(r.nextInt(26) + 65));
                    code += ch;
                    break;
                case 1:
                    String ch1 = String.valueOf((char)(r.nextInt(26) + 97));
                    code += ch1;
                    break;
                case 2:
                    code += Integer.toString(r.nextInt(10));
                    break;
            }
        }
        return code;
    }
}
