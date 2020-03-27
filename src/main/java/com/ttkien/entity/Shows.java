/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttkien.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kimmy
 */
@Entity
@Table(name = "SHOWS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shows.findAll", query = "SELECT s FROM Shows s"),
    @NamedQuery(name = "Shows.findById", query = "SELECT s FROM Shows s WHERE s.id = :id"),
    @NamedQuery(name = "Shows.findByTitle", query = "SELECT s FROM Shows s WHERE s.title = :title"),
    @NamedQuery(name = "Shows.findByDescription", query = "SELECT s FROM Shows s WHERE s.description = :description"),
    @NamedQuery(name = "Shows.findByYear", query = "SELECT s FROM Shows s WHERE s.year = :year"),
    @NamedQuery(name = "Shows.findByDuration", query = "SELECT s FROM Shows s WHERE s.duration = :duration"),
    @NamedQuery(name = "Shows.findByGenres", query = "SELECT s FROM Shows s WHERE s.genres = :genres"),
    @NamedQuery(name = "Shows.findByDirector", query = "SELECT s FROM Shows s WHERE s.director = :director"),
    @NamedQuery(name = "Shows.findByWriter", query = "SELECT s FROM Shows s WHERE s.writer = :writer"),
    @NamedQuery(name = "Shows.findByCast", query = "SELECT s FROM Shows s WHERE s.cast = :cast"),
    @NamedQuery(name = "Shows.findLastestShow", query = "SELECT s FROM Shows s ORDER BY s.id DESC")})
public class Shows implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(generator="SHOW_SQ")
    @SequenceGenerator(name="SHOW_SQ",sequenceName="SHOW_SQ", allocationSize=5)
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "YEAR")
    private BigInteger year;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DURATION")
    private BigInteger duration;
    @Size(max = 255)
    @Column(name = "GENRES")
    private String genres;
    @Size(max = 255)
    @Column(name = "DIRECTOR")
    private String director;
    @Size(max = 255)
    @Column(name = "WRITER")
    private String writer;
    @Size(max = 255)
    @Column(name = "CAST")
    private String cast;
    @Size(max = 20)
    @Column(name = "TYPE")
    private String type;
    @Lob
    @Column(name = "THUMBNAIL")
    private byte[] thumbnail;

    public Shows() {
    }

    public Shows(BigDecimal id) {
        this.id = id;
    }

    public Shows(BigDecimal id, String title, String description, BigInteger year, BigInteger duration) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
        this.duration = duration;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getYear() {
        return year;
    }

    public void setYear(BigInteger year) {
        this.year = year;
    }

    public BigInteger getDuration() {
        return duration;
    }

    public void setDuration(BigInteger duration) {
        this.duration = duration;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shows)) {
            return false;
        }
        Shows other = (Shows) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ttkien.entity.Shows[ id=" + id + " ]";
    }
    
}
