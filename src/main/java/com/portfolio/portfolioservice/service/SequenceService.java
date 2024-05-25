package com.portfolio.portfolioservice.service;

import com.portfolio.portfolioservice.entity.PortfolioSequenceNumber;
import com.portfolio.portfolioservice.repository.SequenceGeneratorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SequenceService {

    private final SequenceGeneratorRepository sequenceGeneratorRepository;

    public SequenceService(SequenceGeneratorRepository sequenceGeneratorRepository) {
        this.sequenceGeneratorRepository = sequenceGeneratorRepository;
    }

    @Transactional
    public Long getNextSequenceNumber(SequenceType sequenceType) throws Exception {
        PortfolioSequenceNumber sequenceNumber = sequenceGeneratorRepository
                .findBySequenceType(sequenceType)
                .orElseThrow(() -> new Exception("Not found"));
        Long number = sequenceNumber.getNextSequenceNumber();
        sequenceNumber.setNextSequenceNumber(number+1);
        sequenceGeneratorRepository.save(sequenceNumber);
        return number;
    }

    public enum SequenceType{
        PORTFOLIO;
    }
}
