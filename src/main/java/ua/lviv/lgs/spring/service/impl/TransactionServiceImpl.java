package ua.lviv.lgs.spring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.spring.domain.MoneyAccount;
import ua.lviv.lgs.spring.domain.Transaction;
import ua.lviv.lgs.spring.domain.Type;
import ua.lviv.lgs.spring.domain.User;
import ua.lviv.lgs.spring.dto.TransactionDTO;
import ua.lviv.lgs.spring.dto.TransactionWithCategoryDTO;
import ua.lviv.lgs.spring.error.ResourceNotFoundException;
import ua.lviv.lgs.spring.repository.TransactionRepository;
import ua.lviv.lgs.spring.repository.UserRepository;
import ua.lviv.lgs.spring.service.TransactionService;
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
        MoneyAccount currentUserAccount = user.getCurrentAccount();
        transaction.setMoneyAccount(currentUserAccount);
        transactionRepository.save(transaction);
        userRepository.save(user);
        return transactionMapper.toDTO(transaction);
    }

    @Transactional
    public TransactionDTO createInCurrentUserAccount(TransactionDTO transactionDTO) {
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        return createInCurrentUserAccount(transactionDTO, user.getId());
    }

    @Override
    public TransactionDTO findById(Long id) {
        return transactionRepository.findById(id).map(transactionMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException(id));
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

    @Override
    @Transactional(readOnly = true)
    public Page<TransactionWithCategoryDTO> findTypeForCurrentUser(Type type, Pageable pageable) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(currentUsername).orElseThrow(() -> new UsernameNotFoundException(currentUsername));
        MoneyAccount currentAccount = user.getCurrentAccount();
        return transactionRepository.findByMoneyAccountAndType(currentAccount, type, pageable)
                .map(transactionMapper::toDTOWithCategory);
    }
}
