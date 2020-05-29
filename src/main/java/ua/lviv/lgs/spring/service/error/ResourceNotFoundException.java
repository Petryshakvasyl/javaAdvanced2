package ua.lviv.lgs.spring.service.error;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("resource with id " + id + " was not found");
    }
}
