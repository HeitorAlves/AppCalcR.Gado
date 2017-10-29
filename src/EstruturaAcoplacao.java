
import java.text.DecimalFormat;

public class EstruturaAcoplacao {
    Alimento alim;


    float porcAlim_pQ;
    float porcFinal;
    
    public EstruturaAcoplacao(Alimento alim,float porcentagem ){
        this.alim = alim;
        this.porcAlim_pQ = porcentagem;
        this.porcFinal = 0;
    }
    
    public EstruturaAcoplacao(Alimento alim){
        this.alim = alim;
        this.porcAlim_pQ = 0;
        this.porcFinal = 0;
        
    }
    public EstruturaAcoplacao(Alimento alim,float porcentagem,float porcFinal ){
        this.alim = alim;
        this.porcAlim_pQ = porcentagem;
        this.porcFinal = porcFinal;
    }
    

    public Alimento getAlim() {
        return alim;
    }

    public void setAlim(Alimento alim) {
        this.alim = alim;
    }
    
    public float getPorcAlim_pQ() {
        return porcAlim_pQ;
    }

    public void setPorcAlim_pQ(float porcAlim_pQ) {
        this.porcAlim_pQ = porcAlim_pQ;
    }

    public float getPorcFinal() {
        return porcFinal;
    }

    public void setPorcFinal(float porcFinal) {
        this.porcFinal = porcFinal;
    }


    
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("####0.00");
        
        return ("(Nome :"+getAlim().getNome()+"/PorcQ_Alim :"+getPorcAlim_pQ()+"/PorcFinal :"+df.format(getPorcFinal())+")");
    }
    
}
