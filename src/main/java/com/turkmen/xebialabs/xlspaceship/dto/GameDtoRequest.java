package com.turkmen.xebialabs.xlspaceship.dto;

/**
 * Created by turkmenmustafademirci on 11/21/19.
 */
public class GameDtoRequest {
    private String user_id;
    private String full_name;
    private SpaceshipProtocol spaceship_protocol;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public SpaceshipProtocol getSpaceship_protocol() {
        return spaceship_protocol;
    }

    public void setSpaceship_protocol(SpaceshipProtocol spaceship_protocol) {
        this.spaceship_protocol = spaceship_protocol;
    }
}


class SpaceshipProtocol{
    private String hostname;
    private int port;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
