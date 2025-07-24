package com.example.crud.user.infrastructure.http.controller;

import com.example.crud.shared.application.commandBus.ICommandBus;
import com.example.crud.user.domain.command.UserInsertOneCommand;
import com.example.crud.user.domain.model.User;
import com.example.crud.user.infrastructure.http.model.UserInsertOneHttpBodyV1;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@Validated
public class InsertOneUserController {
  private final ICommandBus commandBus;

  @Autowired
  public InsertOneUserController(ICommandBus commandBus) {
    this.commandBus = commandBus;
  }

  @PostMapping
  public ResponseEntity<User> insertOneUser(@Valid @RequestBody UserInsertOneHttpBodyV1 body) {
    final User user = commandBus.execute(new UserInsertOneCommand(body.name));
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }
}