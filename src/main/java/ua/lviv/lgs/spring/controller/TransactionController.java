package ua.lviv.lgs.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.lviv.lgs.spring.domain.Type;
import ua.lviv.lgs.spring.dto.TransactionDTO;
import ua.lviv.lgs.spring.dto.TransactionWithCategoryDTO;
import ua.lviv.lgs.spring.dto.UserDTO;
import ua.lviv.lgs.spring.service.CategoryService;
import ua.lviv.lgs.spring.service.TransactionService;
import ua.lviv.lgs.spring.service.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import static ua.lviv.lgs.spring.Constants.DATE_FORMAT;

@Controller
@Slf4j
public class TransactionController {

    private final TransactionService transactionService;
    private final CategoryService categoryService;
    private final UserService userService;

    public TransactionController(TransactionService transactionService, CategoryService categoryService, UserService userService) {
        this.transactionService = transactionService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @PostMapping("/transactions")
    public String createOrUpdateTransaction(@Valid @ModelAttribute("transaction") TransactionDTO transaction, BindingResult bindingResult,
                                            Principal principal) {
        log.debug("Rest request to create transaction");
        if (bindingResult.hasErrors()) {
            return "createTransaction";
        }
        UserDTO user = userService.findByUsername(principal.getName()).orElseThrow(() -> new UsernameNotFoundException(principal.getName()));
        TransactionDTO created = transactionService.createInCurrentUserAccount(transaction, user.getId());
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

    @GetMapping("/transactions/list")
    @Secured("ROLE_ADMIN")
    public String getIncomePage(Model model, @RequestParam Type type, Pageable pageable) {
        log.info("in comtroller");
        Page<TransactionWithCategoryDTO> transactionPage = transactionService.findTypeForCurrentUser(type, pageable);
        model.addAttribute("transactions", transactionPage);
        model.addAttribute("type", type);
        return "transactions";
    }
}
