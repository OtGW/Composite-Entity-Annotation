package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.Calendar;
import java.util.Set;

@Entity
@Table(name = "EMPLOYEE", schema = "S1")
@Where(clause = "DELETED = 0 OR DELETED IS NULL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATEOFBIRTH")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dateOfBirth;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private Set<Transaction> transactions;


    //move this to superclass for audit fields
    @Column(name = "DELETED")
    private Boolean deleted = Boolean.FALSE;
}
