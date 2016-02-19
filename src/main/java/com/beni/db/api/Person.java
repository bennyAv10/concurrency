package com.beni.db.api;

import java.time.LocalDate;

/**
 * Created by Beni on 19/02/2016.
 */
public class Person {
    public String name;
    public String id;
    public String flat;
    public LocalDate start = LocalDate.MIN;
    public LocalDate end = LocalDate.MAX;
}
