package org.j2os.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Table
@Entity

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long personId;
    @Column(columnDefinition = "VARCHAR(20)")
    private String name;
}
