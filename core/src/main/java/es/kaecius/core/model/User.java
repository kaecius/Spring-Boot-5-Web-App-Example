package es.kaecius.core.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "users", schema = "movielens", catalog = "")
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private byte[] password;
    private Collection<Comment> commentsById;
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
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "password")
    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (!Arrays.equals(password, user.password)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(password);
        return result;
    }

    @OneToMany(mappedBy = "usersByUser")
    public Collection<Comment> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<Comment> commentsById) {
        this.commentsById = commentsById;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<Rating> getRatingsById() {
        return ratingsById;
    }

    public void setRatingsById(Collection<Rating> ratingsById) {
        this.ratingsById = ratingsById;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<Tag> getTagsById() {
        return tagsById;
    }

    public void setTagsById(Collection<Tag> tagsById) {
        this.tagsById = tagsById;
    }
}
