package edu.tumo.banking.service.bank;

import edu.tumo.banking.domain.bank.model.BankModel;
import edu.tumo.banking.exception.BankNotFoundException;
import edu.tumo.banking.repository.bank.BankRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BankServiceImplTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void something() {
        BankRepository mockBankRepository =
                Mockito.mock(BankRepository.class);
        Mockito.when(mockBankRepository.findById(1L)).thenReturn(Optional.of(new BankModel(1L, "Ameria", "something")));
        Mockito.when(mockBankRepository.findById(2L)).thenReturn(Optional.empty());

        BankServiceImpl bankService = new BankServiceImpl(mockBankRepository);
        BankModel byId = bankService.findById(1L);

        Assertions.assertEquals(byId.getBankID(), 1);
        Assertions.assertEquals(byId.getBankName(), "Ameria");
    }

    @Test
    void expectException() {
        BankRepository mockBankRepository =
                Mockito.mock(BankRepository.class);
        Mockito.when(mockBankRepository.findById(1L)).thenReturn(Optional.of(new BankModel(1L, "Ameria", "something")));
        Mockito.when(mockBankRepository.findById(2L)).thenReturn(Optional.empty());

        BankServiceImpl bankService = new BankServiceImpl(mockBankRepository);
        Exception exception = assertThrows(BankNotFoundException.class, () -> {
            BankModel byId = bankService.findById(2L);
        });
    }

}