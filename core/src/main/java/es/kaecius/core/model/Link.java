package es.kaecius.core.model;

import javax.persistence.*;

@Entity
@Table(name = "links", schema = "movielens", catalog = "")
public class Link {
    private int movieId;
    private Integer imdbId;
    private Integer tmdbId;
    private Movie moviesByMovieId;

    @Id
    @Column(name = "movieId")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "imdbId")
    public Integer getImdbId() {
        return imdbId;
    }

    public void setImdbId(Integer imdbId) {
        this.imdbId = imdbId;
    }

    @Basic
    @Column(name = "tmdbId")
    public Integer getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(Integer tmdbId) {
        this.tmdbId = tmdbId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (movieId != link.movieId) return false;
        if (imdbId != null ? !imdbId.equals(link.imdbId) : link.imdbId != null) return false;
        if (tmdbId != null ? !tmdbId.equals(link.tmdbId) : link.tmdbId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = movieId;
        result = 31 * result + (imdbId != null ? imdbId.hashCode() : 0);
        result = 31 * result + (tmdbId != null ? tmdbId.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "movieId", referencedColumnName = "id", nullable = false)
    public Movie getMoviesByMovieId() {
        return moviesByMovieId;
    }

    public void setMoviesByMovieId(Movie moviesByMovieId) {
        this.moviesByMovieId = moviesByMovieId;
    }
}
