package com.getabook.domain.document.entity;

import com.getabook.domain.user.enitity.UserAccount;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USER_DOCUMENT")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_account_id", referencedColumnName = "id")
    private UserAccount userAccount;

    @ManyToOne
    @JoinColumn(name = "document_id", referencedColumnName = "id")
    private CompanyDocument companyDocument;
}
