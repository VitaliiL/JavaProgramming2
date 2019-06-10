package com.course.lapshakov.sem2.interfaces;

import java.util.Map;

public interface DefineCommand extends Command{
    void setMap(Map<String, Double> variables);
}
