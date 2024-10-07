package com.traini8.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Entity representing a Training Center.
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;        // Unique identifier for the training center

    @NotBlank(message = "Center name is required")
    @Size(max = 40, message = "Center name should be less than 40 characters")
    private String centerName;        // Name of the training center

    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code should be exactly 12 alphanumeric characters")
    private String centerCode;        // Unique code for the center, exactly 12 characters

    @Embedded
    private Address address;            // Address details of the training center

    @Min(1)
    private int studentCapacity;        // Maximum number of students the center can accommodate

    @ElementCollection
    private List<String> coursesOffered;        // List of courses offered by the training center

    @JsonIgnore
    private long createdOn;                // Timestamp of when the center was created (ignored in JSON)

    @Email(message = "Invalid email address")
    private String contactEmail;                // Contact email for the training center

    @Pattern(regexp = "^\\d{10}$", message = "Contact phone should be a valid 10-digit number")
    private String contactPhone;            // Contact phone number for the training center



}
