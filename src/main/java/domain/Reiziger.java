package domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "reiziger")
public class Reiziger {

    @Id
    @Column(name = "reiziger_id")
    private int id;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date geboortedatum;
    @OneToOne(
            mappedBy = "reiziger",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Adres adres;
    @OneToMany(mappedBy = "reiziger",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<OVChipkaart> OVC = new ArrayList<>();



    public Reiziger(int id, String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum) {
        this.id = id;
        this.voorletters = voorletters;
        this.achternaam = achternaam;
        this.tussenvoegsel = tussenvoegsel;
        this.geboortedatum = geboortedatum;
//        this.OVC = new ArrayList<>();
    }

    public Reiziger() {

    }

    public List<OVChipkaart> getOVC() {
        return OVC;
    }

   public void addOvCard(OVChipkaart ov){
        OVC.add(ov);
   }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }



    public String toString(){
        if (adres == null){
            if (tussenvoegsel == null){
                return "Reiziger " + voorletters + " " + achternaam + " met reizigers id: " +  id
                        + " geboortedatum " + geboortedatum + " " +  OVC;
            }
            else{
                return "Reiziger " + voorletters + " " + tussenvoegsel + " " + achternaam + " met reizigers id: " +  id
                        + " geboortedatum " + geboortedatum + " " +  OVC;
            }

        }
        else {
            if (tussenvoegsel == null){
                return "Reiziger " + voorletters + " " + achternaam + " met reizigers id: " +  id
                        + " geboortedatum " + geboortedatum + " " + adres + " " +  OVC;
            }
            else {
                return "Reiziger " + voorletters + " " + tussenvoegsel + " " + achternaam + " met reizigers id: " +  id
                        + " geboortedatum " + geboortedatum + " " + adres + " " +  OVC;
            }
        }
    }
}