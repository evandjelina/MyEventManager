package com.example.mem.myeventmanager;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Djina on 31.3.2016.
 */
public class ActivityItems {

    String name;
    String description;
    Date date;

    public ActivityItems (String name, String desc, Date date){
        this.name = name;
        description = desc;
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
