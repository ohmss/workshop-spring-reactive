package com.datastax.workshop.petclinic.owner.db;

import java.io.Serializable;
import java.util.UUID;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;

/**
 * Represents an Owner (Owner) in the data access layer (Cassandra)
 */
@Entity
@CqlName(OwnerEntity.OWNER_TABLE)
public class OwnerEntity implements Serializable {

    /** Serial.*/
    private static final long serialVersionUID = 313944474970753001L;
    
    /** Group schema related constants in a single place. */
    public static final String OWNER_TABLE          = "petclinic_owner";
    public static final String OWNER_ATT_ID         = "id";
    public static final String OWNER_ATT_LASTNAME   = "last_name";
    public static final String OWNER_ATT_FIRSTNAME  = "first_name";
    public static final String OWNER_ATT_ADDRESS    = "address";
    public static final String OWNER_ATT_CITY       = "city";
    public static final String OWNER_ATT_TELEPHONE  = "telephone";
    public static final String OWNER_IDX_NAME       = "petclinic_idx_ownername";
    
    @PartitionKey
    @CqlName(OWNER_ATT_ID)
    private UUID id;

    @CqlName(OWNER_ATT_FIRSTNAME)
    private String firstName;

    @CqlName(OWNER_ATT_LASTNAME)
    private String lastName;

    @CqlName(OWNER_ATT_ADDRESS)
    private String address;

    @CqlName(OWNER_ATT_CITY)
    private String city;
    
    @CqlName(OWNER_ATT_TELEPHONE)
    private String telephone;
    
    public OwnerEntity() {
    }
    
    /** Constructor with initialized identifier. */
    public OwnerEntity(UUID uid) {
        this.id = uid;
    }
    
    /** Constructor with initialized identifier. */
    public OwnerEntity(String uid) {
        this(UUID.fromString(uid));
    }

    /**
     * Getter accessor for attribute 'id'.
     *
     * @return
     *       current value of 'id'
     */
    public UUID getId() {
        return id;
    }

    /**
     * Setter accessor for attribute 'id'.
     * @param id
     * 		new value for 'id '
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Getter accessor for attribute 'firstName'.
     *
     * @return
     *       current value of 'firstName'
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter accessor for attribute 'firstName'.
     * @param firstName
     * 		new value for 'firstName '
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter accessor for attribute 'lastName'.
     *
     * @return
     *       current value of 'lastName'
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter accessor for attribute 'lastName'.
     * @param lastName
     * 		new value for 'lastName '
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter accessor for attribute 'address'.
     *
     * @return
     *       current value of 'address'
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter accessor for attribute 'address'.
     * @param address
     * 		new value for 'address '
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter accessor for attribute 'city'.
     *
     * @return
     *       current value of 'city'
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter accessor for attribute 'city'.
     * @param city
     * 		new value for 'city '
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter accessor for attribute 'telephone'.
     *
     * @return
     *       current value of 'telephone'
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Setter accessor for attribute 'telephone'.
     * @param telephone
     * 		new value for 'telephone '
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
