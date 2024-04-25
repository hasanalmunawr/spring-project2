package hasanalmunawr.Dev.springproject2.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static hasanalmunawr.Dev.springproject2.constant.Constants.*;

@Getter
@AllArgsConstructor
public enum Authority {

    USER(USER_AUTHORITIES),
    ADMIN(ADMIN_AUTHORITIES),
    SUPER_ADMIN(SUPER_ADMIN_AUTHORITIES),
    MANAGER(MANAGER_AUTHORITIES);

    private final String name;



}
