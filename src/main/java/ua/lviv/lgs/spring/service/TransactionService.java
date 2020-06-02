package ua.lviv.lgs.spring.service;

import org.springframework.data.domain.Page;
import ua.lviv.lgs.spring.dto.TransactionDTO;

public interface TransactionService {

    TransactionDTO createInCurrentUserAccount(TransactionDTO transaction, Long id);

    TransactionDTO findById(Long id);

    Page<TransactionDTO> findByUserCurrentAccount(Long userId);

    Page<TransactionDTO> findByUserCurrentAccountAndCategory(Long userId, Long categoryId);

    TransactionDTO update(TransactionDTO transactionDTO);

    void deleteById(Long id);
}
