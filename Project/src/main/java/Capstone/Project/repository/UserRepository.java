package Capstone.Project.repository;

import Capstone.Project.model.Attendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbc;

    private RowMapper<Attendee> rowMapper = new RowMapper<Attendee>() {

        @Override

        public Attendee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Attendee att = new Attendee();

            att.setAttendeeId(rs.getInt("AttendeeID"));
            att.setAttendeeName(rs.getString("AttendeeName"));
            att.setEmail(rs.getString("Email"));
            att.setPhone(rs.getInt("Phone"));
            att.setPassword(rs.getInt("Password"));

            return att;
        }
    };
        public void createAttendee(Attendee att) {
            String sql = "insert into Attendee(AttendeeName, Email, Phone, Password) values (?,?,?,?)";
            jdbc.update(sql,att.getAttendeeName(), att.getEmail(), att.getPhone(), att.getPassword());
        }


}
