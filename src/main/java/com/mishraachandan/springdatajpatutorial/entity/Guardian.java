package com.mishraachandan.springdatajpatutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({@AttributeOverride(name = "name", column = @Column(name = "guardian_name"))
, @AttributeOverride(name="email", column = @Column(name = "guardian_email")),
        @AttributeOverride(name="mobileNbr", column = @Column(name = "guardian_mobile_nbr"))
})
public class Guardian {

    private String name;
    private String email;
    private String mobileNbr;
}
