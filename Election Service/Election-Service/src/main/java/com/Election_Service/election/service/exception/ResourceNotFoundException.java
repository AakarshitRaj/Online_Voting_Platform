//This is a custom exception for handling cases where an election or candidate is not found.

package com.Election_Service.election.service.exception;


public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
