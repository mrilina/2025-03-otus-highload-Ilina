package ru.social.network.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RegisterResponse(@JsonProperty("login") String login) {
}
