package es.kaecius.core.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RatingPK implements Serializable {
    private int userId;
    private int movieId;

    @Column(name = "userId")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "movieId")
    @Id
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RatingPK ratingPK = (RatingPK) o;

        if (userId != ratingPK.userId) return false;
        if (movieId != ratingPK.movieId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + movieId;
        return result;
    }
}
