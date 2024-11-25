package tcs.tpi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String genre;
    private String director;
    private String description;

    private Integer premiere;
}
