package com.getabook.domain.company.enitity;

import com.getabook.domain.document.entity.CompanyDocument;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Builder
@Entity
@Table(name = "COMPANY_ACCOUNT")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CompanyAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    @Column(name = "cash_balance")
    private BigDecimal cashBalance;

    @OneToOne(mappedBy = "companyAccount")
    private Company company;

    @OneToMany(mappedBy = "companyAccount")
    private List<CompanyDocument> companyDocuments;
}
