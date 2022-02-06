package org.example.fraud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckHistory {
    @Id
    @SequenceGenerator(name = "fraud_history_id_seq", sequenceName = "fraud_history_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_history_id_seq")
    private Long id;

    private Long customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Boolean getFraudster() {
        return isFraudster;
    }

    public void setFraudster(Boolean fraudster) {
        isFraudster = fraudster;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
