package com.beni.db.api;

import java.util.List;

/**
 * Created by Beni on 19/02/2016.
 */
public interface DbClient {
    interface Predicate<T> {
        /**
         *
         * @param obj
         * @return 1 include, 0 exclude, -1 exclude and stop
         */
        int test(T obj);
    }
    Person getPerson(String id);
    List<Rate> getRate(MeterRead.MeterType type, Predicate<Rate> test);
    List<MeterRead> getMeterRead(String flatId, Predicate<MeterRead> test);

    void setPerson(Person person);
    void setRate(Rate rate);
    void setMeterREad(MeterRead read);
}
