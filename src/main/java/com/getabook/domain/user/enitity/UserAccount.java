package com.getabook.domain.user.enitity;

import com.getabook.domain.document.entity.UserDocument;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "USER_ACCOUNT")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
    private User user;

    @NotNull
    @Column(name = "points_balance")
    private Long pointsBalance;

    @OneToMany(mappedBy = "userAccount")
    private List<UserDocument> userDocuments;
}
