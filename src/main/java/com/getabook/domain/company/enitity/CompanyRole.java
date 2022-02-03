package com.getabook.domain.company.enitity;

import com.getabook.domain.user.enitity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "COMPANY_ROLE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class CompanyRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
}
