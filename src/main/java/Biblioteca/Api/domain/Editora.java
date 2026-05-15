package Biblioteca.Api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "editora")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da editora é obrigatório")
    @Size(max = 80)
    @Column(nullable = false, length = 80)
    private String nome;

    private String cnpj;

    private String cidade;

    @OneToMany(mappedBy = "editora")
    @JsonIgnoreProperties("editora")
    private List<Livro> livros;

    public Editora() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getCidade() {
        return cidade;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}