package org.example.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
