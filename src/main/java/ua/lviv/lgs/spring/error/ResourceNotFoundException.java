package ua.lviv.lgs.spring.error;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Resource with id " + id + " was not found");
    }
}
