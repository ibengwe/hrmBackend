package abe.version3.hrmv3.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static abe.version3.hrmv3.entity.Permission.*;


@RequiredArgsConstructor
public enum Role {

    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,
                    ADMIN_CREATE,

                    OCS_READ,
                    OCS_UPDATE,
                    OCS_DELETE,
                    OCS_CREATE



            )
    ),
//    USER(Collections.emptySet()),

    USER(
            Set.of(
                    USER_READ,
                    USER_UPDATE,
                    USER_DELETE,
                    USER_CREATE
            )
    ),
    OCS(
            Set.of(

                    OCS_READ,
                    OCS_UPDATE,
                    OCS_DELETE,
                    OCS_CREATE

            )
    )
    ;

    @Getter
    public final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities=getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return authorities;
    }
}
