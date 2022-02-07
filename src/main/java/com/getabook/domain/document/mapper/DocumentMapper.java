package com.getabook.domain.document.mapper;

import com.getabook.domain.document.dto.DocumentDto;
import com.getabook.domain.document.entity.Document;
import org.springframework.stereotype.Component;

@Component
public class DocumentMapper {

    public DocumentDto toDto(Document document) {
        return DocumentDto.builder()
                .id(document.getId())
                .cashPrice(document.getCashPrice())
                .title(document.getTitle())
                .build();
    }
}
