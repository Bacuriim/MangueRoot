package mangue.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class MessageEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "body", nullable = false, columnDefinition = "TEXT")
    private String body;
    
    @Column(name = "image_path", unique = true)
    private String imagePath;

    @Column(name = "audio_path", unique = true)
    private String audioPath;

    @Column(name = "sent_at", nullable = false)
    private LocalDate sentAt;

    @Column(name = "received_at")
    private LocalDate receivedAt;

    @Column(name = "read_at")
    private LocalDate readAt;
}
