package cn.powerdash.libsystem.book.domain;
// Generated 2017-3-2 0:17:49 by Hibernate Tools 3.5.0.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Member generated by hbm2java
 */
@Entity
@Table(name = "member", catalog = "libsystem")
public class Member implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String credentialsName;
    private int credentialsType;
    private String credentialsNum;
    private String address;
    private String telephone;
    private String email;
    private int wxid;
    private int type;
    private String photo;
    private int reward;
    private int rewardUsed;
    private Date registerDate;
    private Date validityStartDate;
    private Date validityEndDate;

    public Member() {
    }

    public Member(String name, String credentialsName, int credentialsType, String credentialsNum, String address,
            String telephone, String email, int wxid, int type, String photo, int reward, int rewardUsed,
            Date registerDate, Date validityStartDate, Date validityEndDate) {
        this.name = name;
        this.credentialsName = credentialsName;
        this.credentialsType = credentialsType;
        this.credentialsNum = credentialsNum;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.wxid = wxid;
        this.type = type;
        this.photo = photo;
        this.reward = reward;
        this.rewardUsed = rewardUsed;
        this.registerDate = registerDate;
        this.validityStartDate = validityStartDate;
        this.validityEndDate = validityEndDate;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "credentials_name", nullable = false, length = 10)
    public String getCredentialsName() {
        return this.credentialsName;
    }

    public void setCredentialsName(String credentialsName) {
        this.credentialsName = credentialsName;
    }

    @Column(name = "credentials_type", nullable = false)
    public int getCredentialsType() {
        return this.credentialsType;
    }

    public void setCredentialsType(int credentialsType) {
        this.credentialsType = credentialsType;
    }

    @Column(name = "credentials_num", nullable = false, length = 20)
    public String getCredentialsNum() {
        return this.credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    @Column(name = "address", nullable = false, length = 50)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "telephone", nullable = false, length = 15)
    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Column(name = "email", nullable = false, length = 60)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "wxid", nullable = false)
    public int getWxid() {
        return this.wxid;
    }

    public void setWxid(int wxid) {
        this.wxid = wxid;
    }

    @Column(name = "type", nullable = false)
    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Column(name = "photo", nullable = false, length = 120)
    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Column(name = "reward", nullable = false)
    public int getReward() {
        return this.reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    @Column(name = "reward_used", nullable = false)
    public int getRewardUsed() {
        return this.rewardUsed;
    }

    public void setRewardUsed(int rewardUsed) {
        this.rewardUsed = rewardUsed;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "register_date", nullable = false, length = 10)
    public Date getRegisterDate() {
        return this.registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "validity_start_date", nullable = false, length = 10)
    public Date getValidityStartDate() {
        return this.validityStartDate;
    }

    public void setValidityStartDate(Date validityStartDate) {
        this.validityStartDate = validityStartDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "validity_end_date", nullable = false, length = 10)
    public Date getValidityEndDate() {
        return this.validityEndDate;
    }

    public void setValidityEndDate(Date validityEndDate) {
        this.validityEndDate = validityEndDate;
    }

}