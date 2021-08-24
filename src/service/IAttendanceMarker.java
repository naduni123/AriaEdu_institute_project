package service;

import model.AttendanceMarker;

import java.util.ArrayList;

public interface IAttendanceMarker {

    public void addAttendance(AttendanceMarker attendanceMarker);
    public ArrayList<AttendanceMarker> viewAttendMarkers();
}
