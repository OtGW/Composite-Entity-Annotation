package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.Set;

@Entity
@Table(name = "CUSTOMER", schema = "S1")
@Where(clause = "DELETED = 0 OR DELETED IS NULL")
@Getter
@Setter
@AllArgsConstructor
public class Customer {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "ADDRESS")
    private String address;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Transaction> transactions;

    //move this to superclass for audit fields
    @Column(name = "DELETED")
    private Boolean deleted = Boolean.FALSE;
}
