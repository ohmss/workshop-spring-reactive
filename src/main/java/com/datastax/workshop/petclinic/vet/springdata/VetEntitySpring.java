package com.datastax.workshop.petclinic.vet.springdata;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;


@Table(VetEntitySpring.VET_TABLE)
public class VetEntitySpring {
    
    /** Groups Constant. */
    public static final String VET_TABLE            = "petclinic_vet";
    public static final String VET_ATT_ID           = "id";
    public static final String VET_ATT_LASTNAME     = "last_name";
    public static final String VET_ATT_FIRSTNAME    = "first_name";
    public static final String VET_ATT_SPECIALTIES  = "specialties";
    public static final String VET_IDX_NAME         = "petclinic_idx_vetname";
    
    @PrimaryKey
    @Column(VET_ATT_ID)
    private UUID id;

    @Column(VET_ATT_FIRSTNAME)
    private String firstName;

    @Column(VET_ATT_LASTNAME)
    @CassandraType(type = CassandraType.Name.TEXT)
    private String lastName;
    
    @Column(VET_ATT_SPECIALTIES)
    @CassandraType(type = CassandraType.Name.SET, typeArguments = Name.TEXT)
    private Set<String> specialties = new HashSet<>(); 
    
    public VetEntitySpring() {}
    
    public VetEntitySpring(String uid) {
        this.id = UUID.fromString(uid);
    }
    
    public VetEntitySpring(String uid, String firstname, String lastname, String...specialties) {
       this(uid);
       this.firstName   = firstname;
       this.lastName    = lastname;
       this.specialties = Set.of(specialties);
    }
    
    public VetEntitySpring(UUID uid, String firstname, String lastname, Set<String> specialties) {
        this.id          = uid;
        this.firstName   = firstname;
        this.lastName    = lastname;
        this.specialties = specialties;
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
     *      new value for 'id '
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
     *      new value for 'firstName '
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
     *      new value for 'lastName '
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter accessor for attribute 'specialties'.
     *
     * @return
     *       current value of 'specialties'
     */
    public Set<String> getSpecialties() {
        return specialties;
    }

    /**
     * Setter accessor for attribute 'specialties'.
     * @param specialties
     *      new value for 'specialties '
     */
    public void setSpecialties(Set<String> specialties) {
        this.specialties = specialties;
    }
    
}
