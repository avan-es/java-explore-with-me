package ru.practicum.category.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class NewCategoryDto {

    @NotBlank
    private String name;
}
