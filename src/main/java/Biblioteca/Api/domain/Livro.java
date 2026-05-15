package Biblioteca.Api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String titulo;

    private String isbn;

    @Column(name = "ano_publicacao")
    private Integer anoPublicacao;

    @DecimalMin(value = "9.90", message = "O preço mínimo é 9.90")
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "id_editora")
    @JsonIgnoreProperties("livros")
    private Editora editora;

    @OneToMany(mappedBy = "livro")
    @JsonIgnoreProperties("livro")
    private List<Avaliacao> avaliacoes;

    public Livro() {
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Editora getEditora() {
        return editora;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}