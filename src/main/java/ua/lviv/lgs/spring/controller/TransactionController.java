package ua.lviv.lgs.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.lviv.lgs.spring.domain.Type;
import ua.lviv.lgs.spring.dto.TransactionDTO;
import ua.lviv.lgs.spring.service.CategoryService;
import ua.lviv.lgs.spring.service.TransactionService;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

import static ua.lviv.lgs.spring.Constants.DATE_FORMAT;

@Controller
@Slf4j
public class TransactionController {

    private final TransactionService transactionService;
    private final CategoryService categoryService;

    public TransactionController(TransactionService transactionService, CategoryService categoryService) {
        this.transactionService = transactionService;
        this.categoryService = categoryService;
    }

    @PostMapping("/transactions")
    public String createOrUpdateTransaction(@Valid @ModelAttribute("transaction") TransactionDTO transaction, BindingResult bindingResult) {
        log.debug("Rest request to create transaction");
        if (bindingResult.hasErrors()) {
            return "createTransaction";
        }
        long userId = 3L; // TODO: 02.06.2020 change to real userId
        TransactionDTO created = transactionService.createInCurrentUserAccount(transaction, userId);
        log.debug("success created transaction {}", created);
        return "createTransactionSuccess";
    }

    @GetMapping("/transaction/create_form")
    public String showCreateTransactionForm(@RequestParam Type type, Model model) {
        TransactionDTO transaction = new TransactionDTO();
        transaction.setDate(new SimpleDateFormat(DATE_FORMAT).format(new Date()));
        transaction.setType(type);
        model.addAttribute("transaction", transaction);
        model.addAttribute("categories", categoryService.findByType(type));
        return "createTransaction";
    }

    @GetMapping("/transaction/{id}/update")
    public String showUpdateTransactionForm(@PathVariable Long id, Model model) {
        TransactionDTO transactionDTO = transactionService.findById(id);
        Type type = transactionDTO.getType();
        model.addAttribute("transaction", transactionDTO);
        model.addAttribute("categories", categoryService.findByType(type));
        return "createTransaction";
    }
}
