package com.getabook.domain.document.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "DOCUMENT")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "cash_price")
    private BigDecimal cashPrice;

    @OneToMany(mappedBy = "document")
    private List<CompanyDocument> companyDocuments;
}
