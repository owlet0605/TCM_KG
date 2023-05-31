package com.example.tcm_kgsystem.service.Impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.example.tcm_kgsystem.entity.Phone;
import com.example.tcm_kgsystem.mapper.PhoneMapper;
import com.example.tcm_kgsystem.service.PhoneService;
import com.example.tcm_kgsystem.service.Util.AliYunUtil;
import com.example.tcm_kgsystem.service.Util.CheckCodeBuilder;
import com.example.tcm_kgsystem.transport.TransportObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    PhoneMapper phoneMapper;

    @Override
    public TransportObject sendPhoneCode(String toPhone) {
        TransportObject transportObject=new TransportObject();
        SendSmsResponse sendSmsResponse = null;
        try{
            String code= CheckCodeBuilder.creatCode();
            /*JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", code);
            String TemplateParam = jsonObject.toJSONString();*/

            System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
            System.setProperty("sun.net.client.defaultReadTimeout", "10000");

            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", AliYunUtil.accessKeyId, AliYunUtil.accessSecret);
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", AliYunUtil.PRODUCT, AliYunUtil.DOMAIN);
            IAcsClient acsClient = new DefaultAcsClient(profile);

            SendSmsRequest request = new SendSmsRequest();
            request.setPhoneNumbers(toPhone);
            request.setSignName(AliYunUtil.signName);
            request.setTemplateCode(AliYunUtil.TemplateCode);
            request.setTemplateParam(code);

            request.setOutId("sgaet2020168");

//            sendSmsResponse = acsClient.getAcsResponse(request);
            acsClient.getAcsResponse(request);

            transportObject.setCode(200);
            transportObject.setMsg("success");
            transportObject.setObject(code);
        }catch (Exception e){
            e.printStackTrace();
            transportObject.setCode(300);
            transportObject.setMsg("fail");
            transportObject.setObject(null);
        }
        return transportObject;
    }

    @Override
    public TransportObject confirmPhoneCode(String phone, String code) {
        TransportObject transportObject=new TransportObject();

        Phone result=phoneMapper.selectByPrimaryKey(phone);
        Date time=new Date();
        if(result.getCode().equals(code)){
            if(time.before(result.getGetTime())){
                transportObject.setCode(200);
                transportObject.setMsg("success");
            }
            else{
                transportObject.setCode(300);
                transportObject.setMsg("timeout");
            }
        }
        else{
            transportObject.setObject(300);
            transportObject.setMsg("fail");
        }
        transportObject.setObject(result);
        return transportObject;
    }
}
