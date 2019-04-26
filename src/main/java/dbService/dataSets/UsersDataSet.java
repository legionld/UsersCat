package dbService.dataSets;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UsersDataSet implements Serializable {
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", unique = true, updatable = false)
    private String login;

    @Column(name = "fname", unique = false, updatable = true)
    private String fname;

    @Column(name = "sname", unique = false, updatable = true)
    private String sname;

    @Column(name = "bdata", unique = false, updatable = false)
    private String bdata;

    @Column(name = "adress", unique = false, updatable = true)
    private String adress;

    @Column(name = "info", unique = false, updatable = true)
    private String info;

    @Column(name = "permission", unique = false, updatable = true)
    private String permission;

    @Column(name = "photo", unique = false, updatable = true)
    private String photo;


    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet() {
    }

    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet(long id, String login, String fname, String sname) {
        this.setId(id);
        this.setLogin(login);
        this.setFname(fname);
        this.setSname(sname);
    }

    public UsersDataSet(String login, String fname, String sname, String bdata,
                        String adress, String info, String permission, String photo) {
        this.setLogin(login);
        this.setFname(fname);
        this.setSname(sname);
        this.setBdata(bdata);
        this.setAdress(adress);
        this.setInfo(info);
        this.setPermission(permission);
        this.setPhoto(photo);
    }

    public UsersDataSet(String name) {
        this.setId(-1);
        this.setLogin(name);
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return this.sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getBdata() {
        return this.bdata;
    }

    public void setBdata(String bdata) {
        this.bdata = bdata;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) { this.adress = adress; }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPermission() { return this.permission; }

    public void setPermission(String permission) { this.permission = permission; }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", name='" + login + '\'' +
                '}';
    }
}