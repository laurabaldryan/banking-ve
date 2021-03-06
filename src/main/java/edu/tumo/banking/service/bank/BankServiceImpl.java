package edu.tumo.banking.service.bank;

import edu.tumo.banking.domain.bank.model.BankModel;
import edu.tumo.banking.exception.BankNotFoundException;
import edu.tumo.banking.repository.bank.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankServiceImpl implements BankService{

    private final BankRepository bankRepository;

    @Autowired

    public BankServiceImpl(BankRepository bankRepository){
        this.bankRepository=bankRepository;
    }

    @Override
    public List<BankModel> findAll() {
        return bankRepository.findAll();
    }

    @Override
    public BankModel add(BankModel bankModel) {
        return (BankModel) bankRepository.add(bankModel);
    }

    @Override
    public BankModel update(BankModel bank) {
        return (BankModel) bankRepository.update(bank);
    }

    @Override
    public BankModel findById(Long id) {
        Optional<BankModel> bankModel= bankRepository.findById(id);
        return bankModel.orElseThrow(BankNotFoundException::new);

    }

    @Override
    public void deleteBankModelBy(Long id) {
        bankRepository.deleteBankModelBy(id);
    }
}
