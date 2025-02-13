package dev.ailakks.internxt.entity;

import lombok.Getter;

@Getter
public class UserSessionEntity {
    private UserEntity user;
    private String token;
    private String newToken;
}
