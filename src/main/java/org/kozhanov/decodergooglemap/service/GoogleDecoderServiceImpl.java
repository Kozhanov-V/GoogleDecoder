package org.kozhanov.decodergooglemap.service;

import org.kozhanov.decodergooglemap.dto.ResponseBody;
import org.kozhanov.decodergooglemap.exception.UnsupportedParamsQuery;
import org.kozhanov.decodergooglemap.repository.DecoderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoogleDecoderServiceImpl implements DecoderService{
    private DecoderRepo decoderRepo;

    @Autowired
    public GoogleDecoderServiceImpl(DecoderRepo decoderRepo) {
        this.decoderRepo = decoderRepo;
    }

    @Override
    public ResponseBody decodeGeolocation(double[] startPos, double[] endPos) {
        if(startPos.length !=2 && endPos.length != 2){
            throw new UnsupportedParamsQuery("Need 2 point in start and end position");
        }

        String startAddress = decoderRepo.getPoint(startPos[0],startPos[1]);
        String endAddress = decoderRepo.getPoint(endPos[0], endPos[1]);

        double distance = decoderRepo.getDistance(startPos, endPos);
        ResponseBody responseBody = new ResponseBody(startPos, endPos, startAddress, endAddress, distance);
        return responseBody;
    }
}
