package org.example.fraud.repository;

import org.example.fraud.model.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepository extends JpaRepository<FraudCheckHistory, Long> {

}
