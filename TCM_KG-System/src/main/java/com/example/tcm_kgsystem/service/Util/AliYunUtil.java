package com.example.tcm_kgsystem.service.Util;

public class AliYunUtil {
    public static String accessKeyId = "*****";
    public static String  accessSecret = "*******";

    public static String signName ="******";

    public static String TemplateCode ="SMS_181236263";

    public static final String PRODUCT = "Dysmsapi";

    public static final String DOMAIN = "dysmsapi.aliyuncs.com";



    public static String specialUrlEncode(String value) throws Exception {
        return java.net.URLEncoder.encode(value, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
    }
    public static String sign(String accessSecret, String stringToSign) throws Exception {
        javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA1");
        mac.init(new javax.crypto.spec.SecretKeySpec(accessSecret.getBytes("UTF-8"), "HmacSHA1"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        return new sun.misc.BASE64Encoder().encode(signData);
    }
}
