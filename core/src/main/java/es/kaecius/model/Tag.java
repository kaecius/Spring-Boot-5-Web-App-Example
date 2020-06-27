/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.kaecius.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author kaecius
 */
@Entity
@Table(name = "tags", catalog = "movielens", schema = "")

public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TagPK tagPK;
    @Column(name = "timestamp")
    private Integer timestamp;
    @JoinColumn(name = "movieId", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Movie movie;
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Tag() {
    }

    public Tag(TagPK tagPK) {
        this.tagPK = tagPK;
    }

    public Tag(int userId, int movieId, String tag) {
        this.tagPK = new TagPK(userId, movieId, tag);
    }

    public TagPK getTagPK() {
        return tagPK;
    }

    public void setTagPK(TagPK tagPK) {
        this.tagPK = tagPK;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tagPK != null ? tagPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tag)) {
            return false;
        }
        Tag other = (Tag) object;
        if ((this.tagPK == null && other.tagPK != null) || (this.tagPK != null && !this.tagPK.equals(other.tagPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.kaecius.model.Tag[ tagPK=" + tagPK + " ]";
    }

}
