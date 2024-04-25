package hasanalmunawr.Dev.springproject2.event;

import hasanalmunawr.Dev.springproject2.entity.UserEntity;
import hasanalmunawr.Dev.springproject2.enumeration.EventType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEvent {
    private UserEntity user;
    private EventType type;
    private Map<?, ?> data;
}
