package by.nces.sert_Keys.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
public class CertSetModel  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date startDate;
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date endDate;

    private String country;
    private String nameUC;
    private int numb;
    private String algEncrypt;
    private String role;
    private String typeC;
    private String signatureAlgorithm;




    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Cert_Id")
    private List<MembersModel> membersModels;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNameUC() {
        return nameUC;
    }

    public void setNameUC(String nameUC) {
        this.nameUC = nameUC;
    }

    public int getNumb() {
        return numb;
    }

    public void setNumb(int numb) {
        this.numb = numb;
    }

    public String getAlgEncrypt() {
        return algEncrypt;
    }

    public void setAlgEncrypt(String algEncrypt) {
        this.algEncrypt = algEncrypt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTypeC() {
        return typeC;
    }

    public void setTypeC(String typeC) {
        this.typeC = typeC;
    }

    public String getSignatureAlgorithm() {
        return signatureAlgorithm;
    }

    public void setSignatureAlgorithm(String signatureAlgorithm) {
        this.signatureAlgorithm = signatureAlgorithm;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<MembersModel> getMembersModels() {
        return membersModels;
    }

    public void setMembersModels(List<MembersModel> membersModels) {
        this.membersModels = membersModels;
    }

    public CertSetModel() {
    }


    public CertSetModel(String country, String nameUC, int numb, String algEncrypt, String role, String typeC, String signatureAlgorithm, String startDate, String endDate) throws ParseException {
        setCountry(country);

        this.nameUC = nameUC;
        this.numb = numb;
        this.algEncrypt = algEncrypt;
        this.role = role;
        this.typeC = typeC;
        this.signatureAlgorithm = signatureAlgorithm;

        this.startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        this.endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
    }


}
