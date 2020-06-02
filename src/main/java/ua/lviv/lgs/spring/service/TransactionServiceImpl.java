package ua.lviv.lgs.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.spring.domain.MoneyAccount;
import ua.lviv.lgs.spring.domain.Transaction;
import ua.lviv.lgs.spring.domain.User;
import ua.lviv.lgs.spring.dto.TransactionDTO;
import ua.lviv.lgs.spring.error.ResourceNotFoundException;
import ua.lviv.lgs.spring.repository.TransactionRepository;
import ua.lviv.lgs.spring.repository.UserRepository;
import ua.lviv.lgs.spring.service.mapper.TransactionMapper;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final TransactionMapper transactionMapper;

    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  UserRepository userRepository,
                                  TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    @Transactional
    public TransactionDTO createInCurrentUserAccount(TransactionDTO transactionDTO, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(userId));
        Transaction transaction = transactionMapper.toEntity(transactionDTO);
        transactionRepository.save(transaction);
        MoneyAccount currentUserAccount = user.getCurrentAccount();
        currentUserAccount.getTransactions().add(transaction);
        userRepository.save(user);
        return transactionMapper.toDTO(transaction);
    }

    @Override
    public TransactionDTO findById(Long id) {
        return null;
    }

    @Override
    public Page<TransactionDTO> findByUserCurrentAccount(Long userId) {
        return null;
    }

    @Override
    public Page<TransactionDTO> findByUserCurrentAccountAndCategory(Long userId, Long categoryId) {
        return null;
    }

    @Override
    public TransactionDTO update(TransactionDTO transactionDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
