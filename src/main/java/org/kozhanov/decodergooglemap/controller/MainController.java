package org.kozhanov.decodergooglemap.controller;

import org.kozhanov.decodergooglemap.dto.RequestParam;
import org.kozhanov.decodergooglemap.dto.ResponseBody;

import org.kozhanov.decodergooglemap.service.DecoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

    private DecoderService decoderService;

    @Autowired
    public MainController(DecoderService decoderService) {
        this.decoderService = decoderService;
    }

    @PostMapping("/")
    public ResponseBody decodeGeolocation(@RequestBody RequestParam requestParam){
        return decoderService.decodeGeolocation(requestParam.getStartPos(), requestParam.getEndPos());
    }

}
