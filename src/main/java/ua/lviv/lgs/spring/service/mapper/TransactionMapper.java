package ua.lviv.lgs.spring.service.mapper;

import lombok.SneakyThrows;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.spring.domain.Check;
import ua.lviv.lgs.spring.domain.Transaction;
import ua.lviv.lgs.spring.dto.TransactionDTO;
import ua.lviv.lgs.spring.dto.TransactionWithCategoryDTO;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(target = "check", ignore = true)
    TransactionDTO toDTO(Transaction transaction);

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "date", target = "date", qualifiedByName = "convertToInstant")
    @Mapping(source = "check", target = "check", qualifiedByName = "convertCheck")
    Transaction toEntity(TransactionDTO transactionDTO);

    TransactionWithCategoryDTO toDTOWithCategory(Transaction transaction);

    @Named("convertToInstant")
    default Instant convertToInstant(String date) {
        LocalDate localDate = LocalDate.parse(date);
        LocalDateTime localDateTime = localDate.atStartOfDay();
        return localDateTime.toInstant(ZoneOffset.UTC);
    }

    @SneakyThrows
    @Named("convertCheck")
    default Check toCheck(MultipartFile file) {
        Check check = new Check();
        check.setData(file.getBytes());
        return check;
    }
}
