package dev.ailakks.internxt.entity;

import lombok.Getter;

@Getter
public class UserEntity {
    private String email;
    private String userId;
    private String mnemonic;
    private String rootFolderId;
    private String name;
    private String lastname;
    private String uuid;
    private int credit;
    private String createdAt;
    private String privateKey;
    private String publicKey;
    private String revocateKey;
    private String avatar;
    private boolean emailVerified;
    private String lastPasswordChangedAt;
}
