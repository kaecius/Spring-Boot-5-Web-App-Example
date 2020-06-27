package es.kaecius.core.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TagPK implements Serializable {
    private int userId;
    private int movieId;
    private String tag;

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

    @Column(name = "tag")
    @Id
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TagPK tagPK = (TagPK) o;

        if (userId != tagPK.userId) return false;
        if (movieId != tagPK.movieId) return false;
        if (tag != null ? !tag.equals(tagPK.tag) : tagPK.tag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + movieId;
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        return result;
    }
}
