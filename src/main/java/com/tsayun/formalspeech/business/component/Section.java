package com.tsayun.formalspeech.business.component;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
@NoArgsConstructor
public class Section {

    private @Id String identifier;
    private String title;
    private String author;
    private String description;
    private Date creationTime;


    public Section(
            String identifier
            , String title
            , String author
            , String description
            , Date creationTime
    ) {
        this.identifier = identifier;
        this.title = title;
        this.author = author;
        this.description = description;
        this.creationTime = creationTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Id
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Section))
            return false;
        Section section = (Section) o;
        return Objects.equals(this.identifier, section.identifier)
                && Objects.equals(this.title, section.title)
                && Objects.equals(this.author, section.author)
                && Objects.equals(this.description, section.description)
                && Objects.equals(this.creationTime, section.creationTime)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.identifier
                ,this.title
                ,this.author
                ,this.description
                ,this.creationTime
        );
    }

    @Override
    public String toString() {
        return "Section{"
                + "identifier='" + this.identifier  + '\''
                + ", title='" + this.title + '\''
                + ", author='" + this.author + '\''
                + ", description='" + this.description + '\''
                + ", creationTime=" + this.creationTime + '\''
                + '}';
    }
}
