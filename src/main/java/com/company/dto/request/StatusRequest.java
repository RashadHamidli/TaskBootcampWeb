package com.company.dto.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StatusRequest {
    private Boolean isDeleted;
    private Boolean isArchive;
    private Boolean isImportant;
}
