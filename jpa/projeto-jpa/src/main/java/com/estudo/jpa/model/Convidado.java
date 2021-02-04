package com.estudo.jpa.model;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Convidado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String local;

    @Column(nullable = false)
    private String data;

    @Column(nullable = false)
    private String horario;

    @ManyToMany
    private List<Evento> eventos;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Convidado convidado = (Convidado) o;
        return codigo == convidado.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Convidado{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", local='" + local + '\'' +
                ", data='" + data + '\'' +
                ", horario='" + horario + '\'' +
                ", eventos=" + eventos +
                '}';
    }
}
