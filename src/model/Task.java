package model;

import java.time.LocalDate;

public class Task {
    private String nome;
    private String descricao;
    private LocalDate dataTermino;
    private int nivelPrioridade;
    private String categoria;
    private Status status;

    public Task(String nome, String descricao, LocalDate dataTermino, int nivelPrioridade, String categoria, Status status) {
        this.nome = nome;
        this.descricao = descricao;
        this.nivelPrioridade = nivelPrioridade;
        this.dataTermino = dataTermino;
        this.categoria = categoria;
        this.status = status;
    }

    public String getName() {
        return nome;
    }

    public int getPriority() {
        return nivelPrioridade;
    }

    public String getCategory() {
        return categoria;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public String getDescricao() {
        return descricao;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format(
                " [%s] %s (Categoria: %s, Prioridade: %d, Vencimento: %s) - %s ",
                status, nome, categoria, nivelPrioridade, dataTermino, descricao
        );
    }
}
