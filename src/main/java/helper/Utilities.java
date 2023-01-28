package helper;


import dao.AppointmentDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointment;

import java.sql.SQLException;
import java.time.*;
import java.util.Locale;


public abstract class Utilities {

    public static ZoneId getZoneId(){
        return ZoneId.systemDefault();
    }

    public static Locale getLocale(){
        return Locale.getDefault();
    }


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

        LocalTime start = LocalTime.of(0, 00);
        LocalTime end = LocalTime.of(23, 45);



        while(start.isBefore(end)){
            appointmentTimes.add(start);
            start = start.plusMinutes(15);
        }
        appointmentTimes.add(LocalTime.of(23, 45));

        return appointmentTimes;
    }

    public static LocalDateTime toTargetTime(LocalDateTime originTime){

        ZonedDateTime origin = originTime.atZone(ZoneId.systemDefault());
        ZonedDateTime target = origin.withZoneSameInstant(ZoneId.of("America/New_York"));

        return target.toLocalDateTime();


    }



}
