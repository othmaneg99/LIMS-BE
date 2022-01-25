package ma.mundiapolis.lims.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    private String name;
    @Column(length = 100000 )
    private String description;
    private boolean isActive;
    private boolean isConsumable;
    private int currentStock;
    private int minStock;
    private String photo;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Laboratory laboratory;

}
