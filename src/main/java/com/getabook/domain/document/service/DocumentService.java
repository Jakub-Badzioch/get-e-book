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
        if (documentDto.getId() == null) {
            throw new ApplicationException("New document shouldn't have id. " + documentDto);
        }
        return this.save(documentDto);
    }

    @Transactional
    public DocumentDto update(DocumentDto documentDto) {
        final boolean exists = documentRepository.existsById(documentDto.getId());
        if (!exists) {
            throw new ApplicationException("There is no document with such id");
        }
        return this.save(documentDto);
    }

    @Transactional
    public void delete(Long id) {
        documentRepository.deleteById(id);
    }

    private DocumentDto save(DocumentDto documentDto) {
        final Document document = documentMapper.fromDto(documentDto);
        documentRepository.save(document);
        return documentMapper.toDto(document);
    }

}
