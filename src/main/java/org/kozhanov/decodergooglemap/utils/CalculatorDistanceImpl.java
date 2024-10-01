package org.kozhanov.decodergooglemap.utils;


import org.checkerframework.checker.units.qual.C;
import org.kozhanov.decodergooglemap.exception.UnsupportedParamsQuery;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static java.lang.Math.*;
import static java.lang.Math.sqrt;

// Рассчет расстояния напрямую без учета маршрута
@Component
public class CalculatorDistanceImpl implements CalculatorDistance{

    @Value("${EARTH_RADIUS}")
    private double EARTH_RADIUS;

    @Override
    public double getDistance(double startPosLng, double startPosLat, double endPosLng, double endPosLat) {

        final double dlng = deg2rad(startPosLng - endPosLng);
        final double dlat = deg2rad(startPosLat - endPosLat);
        final double a = sin(dlat / 2) * sin(dlat / 2) + cos(deg2rad(endPosLat))
                * cos(deg2rad(startPosLat) * sin(dlng / 2) * sin(dlng / 2));
        final double result  = 2 * atan2(sqrt(a), sqrt(1 - a)) * EARTH_RADIUS;
        return result;
    }

    private double deg2rad(final double degree) {
        return degree * (Math.PI / 180);
    }
}
