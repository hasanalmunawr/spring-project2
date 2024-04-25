package hasanalmunawr.Dev.springproject2.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import hasanalmunawr.Dev.springproject2.enumeration.Authority;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "roles")
@JsonInclude(NON_DEFAULT)
public class RoleEntity extends Auditable {

    private String name;
    private Authority authorities;
}
