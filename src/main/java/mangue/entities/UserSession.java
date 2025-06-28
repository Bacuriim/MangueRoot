package mangue.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_sessions")
public class UserSession {

    @EmbeddedId
    private UserSessionId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(nullable = false)
    private LocalDateTime connectedAt;

    private LocalDateTime disconnectedAt;
}
