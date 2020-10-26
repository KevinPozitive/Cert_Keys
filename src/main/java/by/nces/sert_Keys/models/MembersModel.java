package by.nces.sert_Keys.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class MembersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    private String firstName;
    private String secondName;
    private String lastName;
    private String agency;
    private String position;
    private String reason;

    private Long Cert_Id;

    public Long getCert_Id() {
        return Cert_Id;
    }

    public void setCert_Id(Long cert_Id) {
        Cert_Id = cert_Id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public MembersModel() {

    }

    public MembersModel(String firstName, String secondName, String lastName, String agency, String position, String reason, Long cert_Id) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.agency = agency;
        this.position = position;
        this.reason = reason;
        this.Cert_Id = cert_Id;
    }
}
