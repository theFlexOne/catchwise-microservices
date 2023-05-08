package com.flexone.lakeservice.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lake {

    @Id
    private Long id;

    private String name;
    private String notes;
    private String county;

    @ElementCollection
    @CollectionTable(name = "lake_fish", joinColumns = @JoinColumn(name = "lake_id"))
    @Column(name = "fish_id")
    private Set<Long> fishIds;
}
