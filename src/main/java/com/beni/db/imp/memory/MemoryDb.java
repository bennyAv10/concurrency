package com.beni.db.imp.memory;

import com.beni.db.api.DbClient;
import com.beni.db.api.MeterRead;
import com.beni.db.api.Person;
import com.beni.db.api.Rate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Beni on 19/02/2016.
 */
public class MemoryDb implements DbClient {
    private List<Rate> rates = new LinkedList<>();
    private Map<MeterRead.MeterType, List<MeterRead>> reads = new HashMap<>();
    private Map<String, Person> persons = new HashMap<>();


    @Override
    public Person getPerson(String id) {
        return null;
    }

    @Override
    public List<Rate> getRate(MeterRead.MeterType type, Predicate<Rate> test) {
        return null;
    }

    @Override
    public List<MeterRead> getMeterRead(String flatId, Predicate<MeterRead> test) {
        return null;
    }

    @Override
    public void setPerson(Person person) {

    }

    @Override
    public void setRate(Rate rate) {

    }

    @Override
    public void setMeterREad(MeterRead read) {

    }
}
