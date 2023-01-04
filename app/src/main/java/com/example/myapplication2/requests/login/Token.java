package com.example.myapplication2.requests.login;

import lombok.Getter;
import lombok.Setter;


public class Token {
    private String grantType;
    private String accessToken;

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setAccessTokenExpiresIn(Long accessTokenExpiresIn) {
        this.accessTokenExpiresIn = accessTokenExpiresIn;
    }

    public String getGrantType() {
        return grantType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public Long getAccessTokenExpiresIn() {
        return accessTokenExpiresIn;
    }

    private String refreshToken;
    private Long accessTokenExpiresIn;
    public static void distroyToken() {
        Token instance = Token.getInstance();
        instance.setAccessToken(null);
        instance.setRefreshToken(null);
        instance.setGrantType(null);
        instance.setAccessTokenExpiresIn(null);
    }
    public static void of(Token token) {
        Token instance = Token.getInstance();
        instance.setAccessToken(token.getAccessToken());
        instance.setRefreshToken(token.getRefreshToken());
        instance.setGrantType(token.getGrantType());
        instance.setAccessTokenExpiresIn(token.getAccessTokenExpiresIn());
    }

    public Token() {}
    private static class Settings4Holder {
        private static final Token INSTANCE = new Token();
    }

    public static Token getInstance() {
            return Settings4Holder.INSTANCE;
        }
}
