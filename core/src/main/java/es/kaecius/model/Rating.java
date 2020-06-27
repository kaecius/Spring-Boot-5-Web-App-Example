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
@Table(name = "ratings", catalog = "movielens", schema = "")
public class Rating implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RatingPK ratingPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rating")
    private Double rating;
    @Column(name = "timestamp")
    private Integer timestamp;
    @JoinColumn(name = "movieId", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Movie movie;
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Rating() {
    }

    public Rating(RatingPK ratingPK) {
        this.ratingPK = ratingPK;
    }

    public Rating(int userId, int movieId) {
        this.ratingPK = new RatingPK(userId, movieId);
    }

    public RatingPK getRatingPK() {
        return ratingPK;
    }

    public void setRatingPK(RatingPK ratingPK) {
        this.ratingPK = ratingPK;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
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
        hash += (ratingPK != null ? ratingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rating)) {
            return false;
        }
        Rating other = (Rating) object;
        if ((this.ratingPK == null && other.ratingPK != null) || (this.ratingPK != null && !this.ratingPK.equals(other.ratingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.kaecius.model.Rating[ ratingPK=" + ratingPK + " ]";
    }

}
