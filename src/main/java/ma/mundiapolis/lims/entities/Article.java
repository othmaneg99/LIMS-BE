package ma.mundiapolis.lims.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    private String name;
    @Column(length = 100000)
    private String description;
    private boolean isActive;
    private boolean isConsumable;
    private int currentStock;
    private int minStock;
    private String photoName;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Laboratory laboratory;
}
