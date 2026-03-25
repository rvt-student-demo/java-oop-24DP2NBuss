package rvt.studentregistration;

import java.time.*;

public class Student {
    private String vards;
    private String uzvards;
    private String epasts;
    private String personasKods;
    private LocalDateTime timestamp; // saglabājam, kad students tika pievienots

    public Student (String name, String surname, String email, String code, LocalDateTime stamp) {
        this.vards = name; // ieliekam studenta vārdu objektā
        this.uzvards = surname; // ieliekam studenta uzvārdu objektā
        this.epasts = email; // ieliekam studenta e-pastu objektā
        this.personasKods = code; // ieliekam studenta personas kodu objektā
        this.timestamp = stamp; // ieliekam pievienošanas laiku objektā
    }
}