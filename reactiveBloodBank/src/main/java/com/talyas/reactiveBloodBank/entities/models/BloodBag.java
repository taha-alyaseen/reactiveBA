package com.talyas.reactiveBloodBank.entities.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("public.donors")
@AllArgsConstructor
@NoArgsConstructor
public class BloodBag {
}
