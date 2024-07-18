package com.example.apidev.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "api-dev-table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PostModel {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String description;
}
