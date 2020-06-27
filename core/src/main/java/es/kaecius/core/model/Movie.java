package es.kaecius.core.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "movies", schema = "movielens", catalog = "")
public class Movie {
    private int id;
    private String title;
    private String genres;
    private Collection<Comment> commentsById;
    private Link linksById;
    private Collection<Rating> ratingsById;
    private Collection<Tag> tagsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "genres")
    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        if (genres != null ? !genres.equals(movie.genres) : movie.genres != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "moviesByMovie")
    public Collection<Comment> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<Comment> commentsById) {
        this.commentsById = commentsById;
    }

    @OneToOne(mappedBy = "moviesByMovieId")
    public Link getLinksById() {
        return linksById;
    }

    public void setLinksById(Link linksById) {
        this.linksById = linksById;
    }

    @OneToMany(mappedBy = "moviesByMovieId")
    public Collection<Rating> getRatingsById() {
        return ratingsById;
    }

    public void setRatingsById(Collection<Rating> ratingsById) {
        this.ratingsById = ratingsById;
    }

    @OneToMany(mappedBy = "moviesByMovieId")
    public Collection<Tag> getTagsById() {
        return tagsById;
    }

    public void setTagsById(Collection<Tag> tagsById) {
        this.tagsById = tagsById;
    }
}
