package ua.lviv.lgs.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.lgs.spring.error.ResourceNotFoundException;
import ua.lviv.lgs.spring.repository.TransactionRepository;

@RestController
public class CheckController {

    private final TransactionRepository checkRepository;

    public CheckController(TransactionRepository checkRepository) {
        this.checkRepository = checkRepository;
    }

    @GetMapping(value = "/transaction/{id}/check", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] getTransactionCheck(@PathVariable Long id) {
        return checkRepository.findTransactionCheck(id).orElseThrow(() -> new ResourceNotFoundException(id))
                .getData();
    }

}
