package com.hivetech.mvc.entity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="createddate")
    private Date createdDate;
    @Column(name ="modifieddate")
    private Date modifiedDate;

    @Column(name ="createdBy")
    private Date createdBy;
    @Column(name ="modifiedby")
    private Date modifiedby;

    public Date getCreatedDate() {
        return createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Date createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(Date modifiedby) {
        this.modifiedby = modifiedby;
    }
}
