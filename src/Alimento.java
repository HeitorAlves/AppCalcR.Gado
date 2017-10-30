
import java.util.Scanner;



public class Alimento {
    String nome;
    float vPB;
    //valor cheio 88 = 88%
    float vNDT;

    public Alimento(String nome, float PB, float NDT) {
        this.nome = nome;
        this.vPB = PB;
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

    public float getPB() {
        return vPB;
    }

    public void setPB(float valor) {
        this.vPB = valor;
    }

    public String toString(){
        return "|Nome:"+getNome()+"|"+"PB:"+getPB()+"|"+"NDT"+getNDT()+"|\n";

    }

    //calcula varios alimentos porcentagem
}
