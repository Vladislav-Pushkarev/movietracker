package com.push.movietracker.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "extension")
    private String extension;

    @Lob
    @Column(name = "data")
    private byte[] data;

    public Image (){}

    public Image(String name, String extension, byte[] data) {
        this.name = name;
        this.extension = extension;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", extension='" + extension + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
