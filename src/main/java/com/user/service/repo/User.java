package com.user.service.repo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "user")
@Data
@NoArgsConstructor
public class User {

        @Id
        private Long id;
        private String username;
        @Column(name = "amountofposts")
        private String amountOfPosts;

}
