package Capstone.Project.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import Capstone.Project.model.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
@Repository
public class ConferenceRepository {

    @Autowired
    JdbcTemplate jdbc;

    private RowMapper<Session> rowMapper = new RowMapper<Session>() {

        @Override

        public Session mapRow(ResultSet rs, int rowNum) throws SQLException {
            Session sss = new Session();

            sss.setSessionID(rs.getInt("SessionID"));
            sss.setSessionName(rs.getString("SessionName"));
            sss.setStartDate(rs.getObject("StartDate", LocalDate.class));
            sss.setDuration(rs.getInt("Duration"));
            return sss;
        }

    };
    public List<Session> findAll(){
        String sql = "select * from Sessions";
        return jdbc.query(sql, rowMapper);
    }
    public List<Session> getSessionNames(){
        String sql = "SELECT SessionName FROM SESSIONS";
        return jdbc.query(sql, rowMapper);
    }
}
