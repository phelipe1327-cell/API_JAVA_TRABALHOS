package Biblioteca.Api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O comentário é obrigatório")
    @Size(max = 500)
    @Column(length = 500)
    private String comentario;

    @Min(value = 1, message = "A nota mínima é 1")
    @Max(value = 5, message = "A nota máxima é 5")
    private Integer nota;

    @Column(name = "data_avaliacao")
    private LocalDate dataAvaliacao;

    @ManyToOne
    @JoinColumn(name = "id_livro")
    @JsonIgnoreProperties("avaliacoes")
    private Livro livro;

    public Avaliacao() {
    }

    public Long getId() {
        return id;
    }

    public String getComentario() {
        return comentario;
    }

    public Integer getNota() {
        return nota;
    }

    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}