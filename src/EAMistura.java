
import java.util.ArrayList;

//EAMistura, é uma estrutura de acoplamento de misturas
//é uma lista que contém uma lista de alimentos usados, porcentagem de multiplicação e valor resultante da soma pb e ndt
public class EAMistura {
    
    ArrayList<Alimento> alimentos = new ArrayList();
    float porcentagem;
    float resPB;
    float resNDT;

    public EAMistura(ArrayList<Alimento> alimentos,float porcentagem, float resPB, float resNDT) {
        this.alimentos = alimentos;
        this.porcentagem = porcentagem;
        this.resPB = resPB;
        this.resNDT = resNDT;
    }

    public ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(ArrayList<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

    public float getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(float porcentagem) {
        this.porcentagem = porcentagem;
    }

    public float getResPB() {
        return resPB;
    }

    public void setResPB(float resPB) {
        this.resPB = resPB;
    }

    public float getResNDT() {
        return resNDT;
    }

    public void setResNDT(float resNDT) {
        this.resNDT = resNDT;
    }
    
}
