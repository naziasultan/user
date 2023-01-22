package com.user.service.model;

import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class User {
    private Long id;
    private String username;
    private String amountOfPosts;
}
