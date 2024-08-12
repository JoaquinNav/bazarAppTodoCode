package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStock;
    @Column(unique = true, nullable = false)
    private int amount;
    @Column(nullable = false)
    private LocalDate updateDate;
    @Column(nullable = false)
    @OneToOne
    @JoinColumn(name = "fk_id_product")
    private Product aProduct;
}
