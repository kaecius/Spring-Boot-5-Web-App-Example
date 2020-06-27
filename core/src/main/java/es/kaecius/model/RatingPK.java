/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.kaecius.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author kaecius
 */
@Embeddable
public class RatingPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "userId")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "movieId")
    private int movieId;

    public RatingPK() {
    }

    public RatingPK(int userId, int movieId) {
        this.userId = userId;
        this.movieId = movieId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) movieId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RatingPK)) {
            return false;
        }
        RatingPK other = (RatingPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.movieId != other.movieId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.kaecius.model.RatingPK[ userId=" + userId + ", movieId=" + movieId + " ]";
    }

}
