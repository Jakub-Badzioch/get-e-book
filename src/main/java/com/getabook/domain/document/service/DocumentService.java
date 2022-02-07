package com.getabook.domain.document.service;

import com.getabook.domain.document.dto.DocumentDto;
import com.getabook.domain.document.entity.Document;
import com.getabook.domain.document.mapper.DocumentMapper;
import com.getabook.domain.document.repository.DocumentRepository;
import com.getabook.domain.exception.ApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    @Transactional
    public DocumentDto create(DocumentDto documentDto) {
        final Document document = Document.builder()
                .cashPrice(documentDto.getCashPrice())
                .title(documentDto.getTitle())
                .build();
        documentRepository.save(document);
        return documentMapper.toDto(document);
    }

    @Transactional
    public DocumentDto update(DocumentDto documentDto) {
        final Document document = documentRepository.findById(
                documentDto.getId()).orElseThrow(() -> new ApplicationException("There is no document with such id"));
        document.setCashPrice(documentDto.getCashPrice());
        document.setTitle(documentDto.getTitle());
        documentRepository.save(document);
        return documentMapper.toDto(document);
    }

    @Transactional
    public void delete(Long id) {
        documentRepository.deleteById(id);
    }
}
