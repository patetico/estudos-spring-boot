package br.politec.laudos.api.pessoa;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    private Date dataNasc;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genero genero;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataDeNasc) {
        this.dataNasc = dataDeNasc;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

}
