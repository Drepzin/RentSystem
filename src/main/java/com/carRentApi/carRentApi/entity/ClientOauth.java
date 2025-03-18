package com.carRentApi.carRentApi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "client_oauth")
public class ClientOauth {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "client_username")
    private String username;

    @Column(name = "client_secret")
    private String clientSecret;

    @Column(name = "redirect_uri")
    private String redirectUri;

    private String scope;

    public ClientOauth() {
    }

    public ClientOauth(String clientID, String username, String clientSecret, String redirectUri, String scope) {
        this.clientId = clientID;
        this.username = username;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
        this.scope = scope;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientID() {
        return clientId;
    }

    public void setClientID(String clientID) {
        this.clientId = clientID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "ClientOauth{" +
                "id='" + id + '\'' +
                ", clientID='" + clientId + '\'' +
                ", username='" + username + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", redirectUri='" + redirectUri + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
