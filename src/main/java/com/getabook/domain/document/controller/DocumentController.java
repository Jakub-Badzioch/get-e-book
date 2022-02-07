package com.getabook.domain.document.controller;

import com.getabook.domain.document.dto.DocumentDto;
import com.getabook.domain.document.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("document")
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DocumentDto createDocument(@RequestBody DocumentDto documentDto) {
        return documentService.create(documentDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public DocumentDto updateDocument(@RequestBody DocumentDto documentDto){
        return documentService.update(documentDto);
    }


    @DeleteMapping("/{documentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("documentId") Long documentId) {
        documentService.delete(documentId);
    }
}
