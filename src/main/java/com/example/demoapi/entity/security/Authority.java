package com.example.demoapi.entity.security;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "AUTHORITY")
public class Authority implements GrantedAuthority {

    static final long serialVersionUID = -5151435165072034245L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String permission;

    @ManyToMany(mappedBy = "authorities")
    private Set<AccountRole> roles;

    @Override
    public String getAuthority() {
        return this.permission;
    }
}
