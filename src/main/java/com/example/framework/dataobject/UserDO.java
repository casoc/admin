package com.example.framework.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author casoc
 * @version $Id: User.java, v 0.1 2016/11/25 16:55 casoc Exp $
 */
@Entity
@Table(name = "users")
public class UserDO {

    @Column
    @Id
    private Long   id;

    @Column
    private String name;

    @Column
    private String password;

    @Column(name = "gmt_create")
    private Date   gmtCreate;

    @Column(name = "gmt_modified")
    private Date   gmt_modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }
}
