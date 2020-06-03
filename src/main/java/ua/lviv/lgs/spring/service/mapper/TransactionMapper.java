package ua.lviv.lgs.spring.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ua.lviv.lgs.spring.domain.Transaction;
import ua.lviv.lgs.spring.dto.TransactionDTO;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    @Mapping(source = "category.id", target = "categoryId")
    TransactionDTO toDTO(Transaction transaction);

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "date", target = "date", qualifiedByName = "convertToInstant")
    Transaction toEntity(TransactionDTO transactionDTO);

    @Named("convertToInstant")
    default Instant convertToInstant(String date) {
        LocalDate localDate = LocalDate.parse(date);
        LocalDateTime localDateTime = localDate.atStartOfDay();
        return localDateTime.toInstant(ZoneOffset.UTC);
    }
}
