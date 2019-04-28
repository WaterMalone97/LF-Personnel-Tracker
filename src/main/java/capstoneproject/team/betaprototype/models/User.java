package capstoneproject.team.betaprototype.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class User {
    @Id
    public Integer psuid;
    public String firstName;
    public String lastName;
    public String location;
    public String timeIn;
    public String timeOut;
    public Date date;
    public String cert;

    public User(Integer psuid, String firstName, String lastName, String location, String timeIn, String timeOut, String cert) {
        this.psuid = psuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            this.date = simpleDateFormat.parse("2018-09-09");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.cert = cert;
    }

    public User() {
    }
}
