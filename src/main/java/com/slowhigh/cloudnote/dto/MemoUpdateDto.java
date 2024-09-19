package com.slowhigh.cloudnote.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemoUpdateDto {
    @Size(min = 1, max = 100)
    private String title;

    @Size(min = 1, max = 2000)
    private String content;
}
