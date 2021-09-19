package service;

import model.AttendanceMarker;

import java.util.ArrayList;

public interface IAttendanceMarker {

    public void addAttendance(AttendanceMarker attendanceMarker);
    public ArrayList<AttendanceMarker> viewAttendMarkers();
    public AttendanceMarker findById(int id);
    public void updateAttMarker(AttendanceMarker attendanceMarker);
    public boolean delteAttMarker(int id);
}
