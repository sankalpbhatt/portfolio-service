package com.portfolio.portfolioservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sequence_numbers")
public class PortfolioSequenceNumber{
        @Id
        @GeneratedValue
        private UUID id;
        private String sequenceType;
        private Long nextSequenceNumber;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public UUID getId() {
                return id;
        }

        public void setId(UUID id) {
                this.id = id;
        }

        public String getSequenceType() {
                return sequenceType;
        }

        public void setSequenceType(String sequenceType) {
                this.sequenceType = sequenceType;
        }

        public Long getNextSequenceNumber() {
                return nextSequenceNumber;
        }

        public void setNextSequenceNumber(Long nextSequenceNumber) {
                this.nextSequenceNumber = nextSequenceNumber;
        }

        public LocalDateTime getCreatedAt() {
                return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
                this.createdAt = createdAt;
        }

        public LocalDateTime getUpdatedAt() {
                return updatedAt;
        }

        public void setUpdatedAt(LocalDateTime updatedAt) {
                this.updatedAt = updatedAt;
        }
}
