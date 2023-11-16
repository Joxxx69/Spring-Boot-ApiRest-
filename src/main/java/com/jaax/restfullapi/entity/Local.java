package com.jaax.restfullapi.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "locals")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder //patron de diseno builder
public class Local {
    
    @Id
    // es como una secuencia 
    @GeneratedValue(strategy = GenerationType.AUTO) // generacion de ids para la tabla
    private Long id;

    @NotBlank(message = "Please add the name")
    private String name;
    private String floor;
    @Length(min=4,max = 12,message = "Code must be between 4 and 12 characters")
    private String code;
}
