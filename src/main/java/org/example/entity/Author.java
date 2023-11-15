package org.example.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import jdk.jfr.Enabled;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    // Many Authors to Many Books
    @ManyToMany(mappedBy = "authors")
    // This shows that books list is going to be mapped by the authors property of the books
    private Set<Book> books = new HashSet<>() ;

    public Author(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;

        return getId().equals(author.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
