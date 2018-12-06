package com.moneysupermarket.retroactions.controller;

import com.moneysupermarket.retroactions.domain.RetroAction;
import com.moneysupermarket.retroactions.response.RetroActionResponse;
import com.moneysupermarket.retroactions.service.RetroActionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class RetroActionController {

    private RetroActionService retroActionService;

    @PostMapping(value = "/action")
    public ResponseEntity<RetroActionResponse> save(@RequestBody RetroAction retroAction) {
        retroActionService.save(retroAction);
        return new ResponseEntity<>(RetroActionResponse
                .builder()
                .id(retroAction.getId())
                .message("Action created")
                .build(),
                HttpStatus.OK);
    }

    @GetMapping("/action/{id}")
    public ResponseEntity<RetroAction> get(@PathVariable String id) {
        Optional<RetroAction> retroAction = retroActionService.getById(id);

        return retroAction.isPresent()
                ? new ResponseEntity<>(retroAction.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/actions")
    public ResponseEntity<List<RetroAction>> getAll() {
        List<RetroAction> retroActions = retroActionService.getAll();

        return retroActions.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(retroActions, HttpStatus.OK);
    }

    @PutMapping("/action")
    public ResponseEntity<RetroActionResponse> update(@RequestBody RetroAction retroAction) {
        retroActionService.update(retroAction);
        return new ResponseEntity<>(RetroActionResponse
                .builder()
                .id(retroAction.getId())
                .message("Action updated")
                .build(),
                HttpStatus.OK);
    }

    @DeleteMapping("/action/{id}")
    public ResponseEntity<RetroActionResponse> delete(@PathVariable String id) {
        retroActionService.delete(id);
        return new ResponseEntity<>(RetroActionResponse
                .builder()
                .id(id)
                .message("Action deleted")
                .build(),
                HttpStatus.OK);
    }

}
