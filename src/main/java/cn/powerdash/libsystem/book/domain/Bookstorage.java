package cn.powerdash.libsystem.book.domain;
// Generated 2017-3-2 0:17:49 by Hibernate Tools 3.5.0.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Bookstorage generated by hbm2java
 */
@Entity
@Table(name = "bookstorage", catalog = "libsystem")
public class Bookstorage implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String isbn;
    private int barcode;
    private int serial;
    private String location;
    private int reward;
    private int inventory;

    public Bookstorage() {
    }

    public Bookstorage(String isbn, int barcode, int serial, String location, int reward, int inventory) {
        this.isbn = isbn;
        this.barcode = barcode;
        this.serial = serial;
        this.location = location;
        this.reward = reward;
        this.inventory = inventory;
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

    @Column(name = "ISBN", nullable = false, length = 50)
    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Column(name = "barcode", nullable = false)
    public int getBarcode() {
        return this.barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    @Column(name = "serial", nullable = false)
    public int getSerial() {
        return this.serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    @Column(name = "location", nullable = false, length = 50)
    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "reward", nullable = false)
    public int getReward() {
        return this.reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    @Column(name = "inventory", nullable = false)
    public int getInventory() {
        return this.inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

}
