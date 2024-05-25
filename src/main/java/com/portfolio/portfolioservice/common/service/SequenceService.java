package com.portfolio.portfolioservice.common.service;

import com.portfolio.portfolioservice.common.entity.SequenceNumber;
import com.portfolio.portfolioservice.common.repository.SequenceGeneratorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SequenceService {

    private final SequenceGeneratorRepository sequenceGeneratorRepository;

    public SequenceService(SequenceGeneratorRepository sequenceGeneratorRepository) {
        this.sequenceGeneratorRepository = sequenceGeneratorRepository;
    }

    @Transactional
    public Long getNextSequenceNumber(SequenceType sequenceType) throws Exception {
        SequenceNumber sequenceNumber = sequenceGeneratorRepository
                .findBySequenceType(sequenceType)
                .orElseThrow();
        Long number = sequenceNumber.getNextSequenceNumber();
        sequenceNumber.setNextSequenceNumber(number + 1);
        sequenceGeneratorRepository.save(sequenceNumber);
        return number;
    }

    public enum SequenceType {
        PORTFOLIO,
        THEME;

        public String getPrefix() {
            return name().substring(0, 1);
        }
    }
}
