package com.ideas.customer;

public record CustomerRegistrationRequest (
        String firstName,
        String lastName,
        String email) {
}
