package org.kozhanov.decodergooglemap.service;

import org.kozhanov.decodergooglemap.dto.ResponseBody;

public interface DecoderService {
    public ResponseBody decodeGeolocation(double[] startPos, double[] endPos);
}
