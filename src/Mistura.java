
import java.util.ArrayList;


public class Mistura {
    //estrutura é uma lista com uma lista de alimentos, res de pb, e ndt. assim como a constante de multiplicação usada
    ArrayList<EAMistura> EAMistura = new ArrayList();
    ArrayList<Float>  porcNegada = new ArrayList<>();
    ArrayList<Float> porcGerada = new ArrayList<>();
    boolean aceito;
    
    public void Mistura(ArrayList<Alimento> list, float PB, float NDT){
        geraPorc(list,PB);
        
    }
    public void geraPorc(ArrayList<Alimento> list,float PB){
        
        float auxPB = 0;
        for(Alimento cont : list){
            auxPB = auxPB + cont.vPB;
        }
        float w = PB-5;
        while(w<PB){
        porcGerada.add(w/auxPB);
        w = w + 0.1f;
        }
    }
    
    public Alimento mePbmeNDT(ArrayList<Alimento> list, float PB, float NDT, ArrayList porcNegada,ArrayList porcGerada){
        //variavel de repetição
        boolean aceito = false;
        //variavel para retorno
        Alimento complexo = null;

        //deleta porcentagens invalidas para NDT
        for(Object cont :porcNegada){
            for(Object cont1 :porcGerada){
                if(porcNegada.equals(porcGerada)){
                    porcGerada.remove(cont1);
                }
            }
            
        }
        
        //repetição para achar valor que atende pb e ndt menores
        while(aceito){
        
            float auxResPB = 0;
            float auxResNDT = 0;
        
        
            for(Alimento i : list){
                auxResPB = auxResPB+ i.vPB*(float)porcGerada.get(0);
                auxResNDT = auxResNDT + i.vNDT*(float)porcGerada.get(0);
            }
            if(auxResNDT<NDT){
                complexo.setNDT(auxResNDT);
                complexo.setPB(auxResPB);
                complexo.setNome("Mistura mePmeN");
                aceito = true;
            }
            else{
                porcGerada.remove(0);

            }
        }
        
    return complexo;
    }
    public void mePbmaNDT(ArrayList<Alimento> list, float PB, float NDT){
        
    }
    public void maPbmeNDT(ArrayList<Alimento> list, float PB, float NDT){
        
    }
    public void maPbmaNDT(ArrayList<Alimento> list, float PB, float NDT){
        
    }
    
    public void returnPorcMistura(ArrayList<EstruturaAcoplacao> lista){
        
    }
    
}
