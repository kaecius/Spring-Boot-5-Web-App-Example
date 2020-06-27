package es.kaecius.core.model;

import javax.persistence.*;

@Entity
@Table(name = "ratings", schema = "movielens", catalog = "")
@IdClass(RatingPK.class)
public class Rating {
    private int userId;
    private int movieId;
    private Double rating;
    private Integer timestamp;
    private User usersByUserId;
    private Movie moviesByMovieId;

    @Id
    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "movieId")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "rating")
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "timestamp")
    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating1 = (Rating) o;

        if (userId != rating1.userId) return false;
        if (movieId != rating1.movieId) return false;
        if (rating != null ? !rating.equals(rating1.rating) : rating1.rating != null) return false;
        if (timestamp != null ? !timestamp.equals(rating1.timestamp) : rating1.timestamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + movieId;
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    public User getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(User usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "movieId", referencedColumnName = "id", nullable = false)
    public Movie getMoviesByMovieId() {
        return moviesByMovieId;
    }

    public void setMoviesByMovieId(Movie moviesByMovieId) {
        this.moviesByMovieId = moviesByMovieId;
    }
}
