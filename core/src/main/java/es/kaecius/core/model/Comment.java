package es.kaecius.core.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comments", schema = "movielens", catalog = "")
public class Comment {

    private int id;
    private String text;
    private Integer user;
    private Integer movie;
    private Timestamp date;
    private User usersByUser;
    private Movie moviesByMovie;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "user")
    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    @Basic
    @Column(name = "movie")
    public Integer getMovie() {
        return movie;
    }

    public void setMovie(Integer movie) {
        this.movie = movie;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != comment.id) return false;
        if (text != null ? !text.equals(comment.text) : comment.text != null) return false;
        if (user != null ? !user.equals(comment.user) : comment.user != null) return false;
        if (movie != null ? !movie.equals(comment.movie) : comment.movie != null) return false;
        if (date != null ? !date.equals(comment.date) : comment.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (movie != null ? movie.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    public User getUsersByUser() {
        return usersByUser;
    }

    public void setUsersByUser(User usersByUser) {
        this.usersByUser = usersByUser;
    }

    @ManyToOne
    @JoinColumn(name = "movie", referencedColumnName = "id")
    public Movie getMoviesByMovie() {
        return moviesByMovie;
    }

    public void setMoviesByMovie(Movie moviesByMovie) {
        this.moviesByMovie = moviesByMovie;
    }
}
