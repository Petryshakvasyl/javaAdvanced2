package ua.lviv.lgs.spring.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.lviv.lgs.spring.domain.Type;
import ua.lviv.lgs.spring.dto.TransactionDTO;
import ua.lviv.lgs.spring.dto.TransactionWithCategoryDTO;

public interface TransactionService {

    TransactionDTO createInCurrentUserAccount(TransactionDTO transaction, Long userId);

    TransactionDTO findById(Long id);

    Page<TransactionDTO> findByUserCurrentAccount(Long userId);

    Page<TransactionDTO> findByUserCurrentAccountAndCategory(Long userId, Long categoryId);

    TransactionDTO update(TransactionDTO transactionDTO);

    void deleteById(Long id);

    Page<TransactionWithCategoryDTO> findTypeForCurrentUser(Type type, Pageable pageable);
}
