package com.traini8.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Center name is required")
    @Size(max = 40, message = "Center name should be less than 40 characters")
    private String centerName;

    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code should be exactly 12 alphanumeric characters")
    private String centerCode;

    @Embedded
    private Address address;

    @Min(1)
    private int studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    @JsonIgnore
    private long createdOn;

    @Email(message = "Invalid email address")
    private String contactEmail;

    @Pattern(regexp = "^\\d{10}$", message = "Contact phone should be a valid 10-digit number")
    private String contactPhone;



}
