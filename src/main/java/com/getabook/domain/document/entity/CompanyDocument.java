package com.getabook.domain.document.entity;

import com.getabook.domain.company.enitity.CompanyAccount;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "COMPANY_DOCUMENT")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CompanyDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_account_id", referencedColumnName = "id")
    private CompanyAccount companyAccount;

    @ManyToOne
    @JoinColumn(name = "document_id", referencedColumnName = "id")
    private Document document;

    @NotNull
    @Column(name = "points_price")
    private Long pointsPrice;

    @OneToMany(mappedBy = "companyDocument")
    private List<UserDocument> userDocuments;
}
