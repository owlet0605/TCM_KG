package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.entity.Tcm;
import com.example.tcm_kgsystem.entity.TcmWithBLOBs;
import com.example.tcm_kgsystem.service.Util.ESUtil;
import com.example.tcm_kgsystem.transport.TransportObject;
import com.example.tcm_kgsystem.service.TcmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/tcm")
public class TcmController {

    @Autowired
    TcmService tcmService;
    @Autowired
    ESUtil esUtil;

    @RequestMapping("/insert")
    TransportObject tcmInsert(TcmWithBLOBs tcm){
        return tcmService.TcmInsert(tcm);
    }

    @RequestMapping("/delete")
    TransportObject tcmDelete(TcmWithBLOBs tcm){
        return tcmService.TcmDelete(tcm.getTcmId());
    }

    @RequestMapping("/change")
    TransportObject tcmChange(TcmWithBLOBs tcm){
        return tcmService.TcmChange(tcm);
    }

    @RequestMapping("/show/all")
    TransportObject ShowAll(@RequestParam int page){
        return tcmService.ShowAll(page);
    }

    @RequestMapping("/show/initial")
    TransportObject ShowByInitial(@RequestParam String initial, @RequestParam int page){
        if(initial.equals("#")){
            return tcmService.ShowAll(page);
        }
        else{
            return tcmService.ShowByInitial(initial, page);
        }

    }

    @RequestMapping("/show/inductive")
    TransportObject ShowByInductive(@RequestParam String inductive, @RequestParam int page){
        if(inductive.equals("#")){
            return tcmService.ShowAll(page);
        }
        else {
            return tcmService.ShowByInductive(inductive, page);
        }
    }

    @RequestMapping("/show/taste")
    TransportObject ShowByTaste(@RequestParam String taste, @RequestParam int page){
        if(taste.equals("#")){
            return tcmService.ShowAll(page);
        }
        else {
            return tcmService.ShowByTaste(taste, page);
        }
    }

    @RequestMapping("/show/property")
    TransportObject ShowByProperty(@RequestParam String property, @RequestParam int page){
        if(property.equals("#")){
            return tcmService.ShowAll(page);
        }
        else {
            return tcmService.ShowByProperty(property, page);
        }
    }

    @RequestMapping("/select")
    TransportObject select(@RequestParam String str, @RequestParam int page){
        return tcmService.Select(str,page);
    }

    @RequestMapping("/get")
    TransportObject getTcm(Tcm tcm){
        return tcmService.getTcm(tcm.getTcmId());
    }

    @RequestMapping("/build")
    TransportObject build(){
        return esUtil.buildTcm();
    }

    @RequestMapping("/deleteES")
    TransportObject delete(){
        return esUtil.deleteAllTcm();
    }

    @RequestMapping("/allES")
    TransportObject search(){
        return esUtil.searchAllTcm();
    }
}
