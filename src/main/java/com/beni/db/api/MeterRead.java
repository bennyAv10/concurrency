package com.beni.db.api;

import java.time.LocalDate;

/**
 * Created by Beni on 19/02/2016.
 */
public class MeterRead {
    public enum MeterType {
        WATER,
        GAS,
        ELECTRIC
    }

    public String ApartmentId;
    public MeterRead type;
    public LocalDate date;
    public double value;
}
