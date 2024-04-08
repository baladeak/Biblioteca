/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author MatheusSabino
 */
public class Biblioteca {

    public String nomeBiblioteca;
    public String endereco;
    public ArrayList<Livro> livros;

    public Biblioteca(String biblioteca, String endereco) {
        this.nomeBiblioteca = biblioteca;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Biblioteca{" + "biblioteca=" + nomeBiblioteca + ", endereco=" + endereco + '}';
    }

    public String getNomeBiblioteca() {
        return nomeBiblioteca;
    }

    public void setNomeBiblioteca(String biblioteca) {
        this.nomeBiblioteca = biblioteca;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public void imprimirTudo(Integer i) {

        System.out.println("Nome do Livro :" + livros.get(i).getNome());
        System.out.println("Genero :" + livros.get(i).getGenero());
        System.out.println("Nome do autor :" + livros.get(i).getAutor().getNome());
        System.out.println("Nacionalidade autor :" + livros.get(i).getAutor().getNacionalidade());
        System.out.println("Data de nascimento autor :" + livros.get(i).getAutor().getDataNascimento());
        System.out.println("Num de Exemplares :" + livros.get(i).getNumExemplares());
        System.out.println("");

    }

}
