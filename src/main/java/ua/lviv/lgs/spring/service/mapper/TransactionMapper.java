package ua.lviv.lgs.spring.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.lviv.lgs.spring.domain.Transaction;
import ua.lviv.lgs.spring.dto.TransactionDTO;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    @Mapping(source = "category.id", target = "categoryId")
    TransactionDTO toDTO(Transaction transaction);

    @Mapping(source = "categoryId", target = "category.id")
    Transaction toEntity(TransactionDTO transactionDTO);
}
