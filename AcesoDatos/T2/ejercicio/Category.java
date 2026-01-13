package org.example;

import jakarta.persistence.*; // O javax.persistence si usas versiones antiguas

@Entity
@Table(name = "categories") // IMPORTANTE: Revisa si en tu BBDD está en mayúscula o minúscula
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private int id;

    @Column(name = "CategoryName")
    private String categoryName;

    @Column(name = "Description")
    private String description;

    // Constructores, Getters y Setters
    public Category() {}

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    // ... resto de getters y setters

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + categoryName;
    }
}