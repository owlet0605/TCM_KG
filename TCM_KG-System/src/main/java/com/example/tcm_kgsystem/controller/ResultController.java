package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.entity.Result;
import com.example.tcm_kgsystem.service.ResultService;
import com.example.tcm_kgsystem.transport.TransportObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/result")
public class ResultController {

    @Autowired
    ResultService resultService;

    @RequestMapping("/insert")
    TransportObject resultInsert(Result result){
        return resultService.resultInsert(result);
    }

    @RequestMapping("/show")
    TransportObject ShowResult(Result result){
        return resultService.showDetail(result.getResultId());
    }

    @RequestMapping("/do")
    TransportObject resultIt(Result result){
        return resultService.resultIt(result.getResultId());
    }
}
