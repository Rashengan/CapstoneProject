package Capstone.Project.model;

import javax.persistence.*;

@Entity
@Table
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer AttendeeId;
    @Column
    public String AttendeeName;
    @Column
    public String Email;
    @Column
    public Integer Password;
    @Column
    public Integer Phone;

    public Integer getAttendeeId() {
        return AttendeeId;
    }
    public void setAttendeeId(Integer attendeeId) {
        AttendeeId = attendeeId;
    }
    public String getAttendeeName() {
        return AttendeeName;
    }
    public void setAttendeeName(String attendeeName) {
        AttendeeName = attendeeName;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public Integer getPassword() {
        return Password;
    }
    public void setPassword(Integer password) {
        Password = password;
    }
    public Integer getPhone() {
        return Phone;
    }
    public void setPhone(Integer phone) {
        Phone = phone;
    }


}
