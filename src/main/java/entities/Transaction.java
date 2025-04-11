package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.Set;

@Entity
@Table(name = "TRANSACTION", schema = "S1")
@Where(clause = "DELETED = 0 OR DELETED IS NULL")
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    @Id
    @Column(name = "ID")
    private Long id;

    //In a real app this would be its own object, but for now I'll keep it simple
    @Column(name = "RECEIPT")
    private String receipt;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    //move this to superclass for audit fields
    @Column(name = "DELETED")
    private Boolean deleted = Boolean.FALSE;
}
