package testgroup.filmography.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "user")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int age;

    @Column
    private String film;

    @Column
    private String lastName;

    public User() {
    }

    public User(int age, String film, String lastName) {
        this.age = age;
        this.film = film;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) { this.age = age; }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Use {id = '%s', age = '%d', film = '%s', lastName =  '%s'}", getId(), getAge(), getFilm(), getLastName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(film, user.film) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, film, lastName);
    }
}
