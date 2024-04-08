/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author MatheusSabino
 */
public class Livro {
    private Integer id;
    private String nome;
    private Autor autor;
    private String genero;
    private Integer numExemplares;

    public Livro(Integer id, String nome, Autor autor, String genero, Integer numExemplares) {
        this.nome = nome;
        this.autor = autor;
        this.genero = genero;
        this.numExemplares = numExemplares;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getNumExemplares() {
        return numExemplares;
    }

    public void setNumExemplares(Integer numExemplares) {
        this.numExemplares = numExemplares;
    }
    
    
}

