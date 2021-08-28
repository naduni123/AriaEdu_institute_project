package service;

import model.TimeSlot;

import java.util.ArrayList;

public interface ITimeSlot {

    public void AddTimeSlot(TimeSlot timeSlot);

    public ArrayList<TimeSlot> viewTime();

}
