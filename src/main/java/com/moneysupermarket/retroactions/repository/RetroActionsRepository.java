package com.moneysupermarket.retroactions.repository;

import com.moneysupermarket.retroactions.domain.RetroAction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RetroActionsRepository extends MongoRepository<RetroAction, String> {
}
