package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record ExampleEntity(@Id Integer id) {}
