package com.moneysupermarket.retroactions.service;

import com.moneysupermarket.retroactions.domain.RetroAction;
import com.moneysupermarket.retroactions.repository.RetroActionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RetroActionService {

    private RetroActionsRepository retroActionsRepository;

    public void save(RetroAction retroAction) {
        retroActionsRepository.save(retroAction);
    }

    public Optional<RetroAction> getById(String id) {
        return retroActionsRepository.findById(id);
    }

    public List<RetroAction> getAll() {
        return retroActionsRepository.findAll();
    }

    public void update(RetroAction retroAction) {
        retroActionsRepository.findById(retroAction.getId())
                .map(action -> {
                    action.setTitle(retroAction.getTitle());
                    action.setDescription(retroAction.getDescription());
                    action.setStatus(retroAction.getStatus());
                    return retroActionsRepository.save(action);
                });
    }

    public void delete(String id) {
        retroActionsRepository.deleteById(id);
    }
}
