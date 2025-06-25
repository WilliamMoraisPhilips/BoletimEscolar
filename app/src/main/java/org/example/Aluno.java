package org.example;

public class Aluno {
    private Double[] notas = new Double[3];

    private String nome;

    private String situacao;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao() {
        if (situacao.isBlank()){
            throw new IllegalArgumentException("A situação do aluno não pode estar vazio");
        }else{
            if (mediaFinal() >= 7 && mediaFinal() <=10) {
                this.situacao = "Aprovado";
            }else if (mediaFinal() >= 5 || mediaFinal() < 7){
                this.situacao = "Recuperação";
            }else if (mediaFinal() < 5){
                this.situacao = "Reprovado";
            }else{
                throw new IllegalArgumentException("Há algum erro com a digitação das notas do aluno, revise as notas");
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.isBlank()){
            throw new IllegalArgumentException("O nome do aluno não pode estar vazio");
        }else{
            this.nome = nome;
        }
    }

    public Double[] getNotas() {
        return notas;
    }

    public void setNotas(Double[] notas) {
        this.notas = notas;
    }

    public void adicionarNota(Double nota) throws Exception {
        if (nota < 0){
            throw new IllegalArgumentException("A nota não pode ser menor que 0");
        }else if (estaCheio(notas)){
            throw new Exception("A quantidade máxima de notas já foi inserida");
        }else{
            for (int i = 0; i < notas.length; i++) {
                if (notas[i] == null){
                    notas[i] = nota;
                    break;
                }
            }
        }
    }

    private static boolean estaCheio(Double[] notas){
        for (Double nota : notas) {
            if (nota == null){
                return false;
            }
        }
        return true;
    }

    private Double mediaFinal(){
        return  (notas[0] + notas[1] + notas[2]) /3;
    }

    private String relatorioFinal(){
        String relatorio = "Relatório Final do Estudante" +
                "\n Nome: " + getNome() +
                "\n Notas: " + getNotas().toString() +
                "\n Média Final: " + mediaFinal() +
                "\n Situação: " + getSituacao();

        return relatorio;
    }

    public static void main(String[] args) throws Exception {
        Aluno aluno = new Aluno();
        aluno.setNome("João");
        aluno.adicionarNota(10.0);
        aluno.adicionarNota(8.0);
        aluno.adicionarNota(4.0);
        aluno.setSituacao();
        aluno.relatorioFinal();
    }
}
