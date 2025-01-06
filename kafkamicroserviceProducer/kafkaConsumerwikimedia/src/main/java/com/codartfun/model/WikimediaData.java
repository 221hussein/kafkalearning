package com.codartfun.model;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "wikimedia_rechantChange")
@Setter
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private String wikiEventData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWikiEventData() {
        return wikiEventData;
    }

    public void setWikiEventData(String wikiEventData) {
        this.wikiEventData = wikiEventData;
    }
}
