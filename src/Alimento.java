
import java.util.Scanner;



public class Alimento {
    String nome;
    float vPB;
    //valor cheio 88 = 88%
    float vNDT;

    public Alimento(String nome, float valor, float NDT) {
        this.nome = nome;
        this.vPB = valor;
        this.vNDT = NDT;
    }

    public float getNDT() {
        return vNDT;
    }

    public void setNDT(float NDT) {
        this.vNDT = NDT/100;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return vPB;
    }

    public void setValor(float valor) {
        this.vPB = valor;
    }


    //calcula varios alimentos porcentagem
}
