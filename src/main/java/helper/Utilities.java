package helper;


import dao.AppointmentDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointment;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;


public abstract class Utilities {

    public static ZoneId getZoneId(){
        return ZoneId.systemDefault();
    }

    public static Locale getLocale(){
        return Locale.getDefault();
    }

    /*public static LocalDateTime convertEstToLocal(){
        ZonedDateTime
        ZonedDateTime newZoneDateTime = localTime.atZone(ZoneId.systemDefault());
        newZoneDateTime.toLocalD
    }*/

    public static ObservableList<Appointment> filterAppointments(LocalDateTime end) throws SQLException {
        ObservableList<Appointment> filteredAppointments = FXCollections.observableArrayList();

        for(Appointment appointment : AppointmentDao.getAll()){
            if(appointment.getStartDateTime().isAfter(LocalDateTime.now().minusDays(1))
                    && appointment.getStartDateTime().isBefore(end)){
                filteredAppointments.add(appointment);
            }
        }
        return filteredAppointments;
    }

    public static ObservableList<LocalTime> getAppointmentTimes(){
        ObservableList<LocalTime> appointmentTimes = FXCollections.observableArrayList();

        //Set the times for EST then return the list for local time?
        LocalTime start = LocalTime.of(8, 00);
        LocalTime end = LocalTime.of(21, 45);

        while(start.isBefore(end)){
            appointmentTimes.add(start);
            start = start.plusMinutes(15);
        }

        return appointmentTimes;
    }


}
