package com.mycomp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.agent.builder.AgentBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Genre extends BaseEntity{
    private String name;

    @ManyToMany(mappedBy = "genreList")
    private List<Movie>movieList;
}
