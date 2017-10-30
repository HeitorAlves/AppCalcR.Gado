import java.util.Scanner;    
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Calculo {
    //variaveis globais de controle função QuadradoPB
    int contador=0,aux=0;
    float maior = 0, menor = 0;
    boolean Bmaior,Bmenor,Baceito,ajustoundt,aceite;
    
    

    ArrayList<EstruturaAcoplacao> TADalimento = new ArrayList<>();
    //start
    float IMS,PB,NDT;
    ArrayList NDTajustado = new ArrayList();
    ArrayList PBajustado = new ArrayList();
    int Taxa_erro_PB = 5,Taxa_erro_NDT =5;
    //É as variaveis modulo x e y subtraidas das variaveis 
    
    //aux fecha calc
    float aux1,aux2,aux3,aux4;
    
    float porcQ_NDT1, porcQ_NDT2;
    float porcQ_PB1,porcQ_PB2;
    //variaveis do quadrado
    //provavel vai virar 2 objetos
    //float item_1,item_2;
    Alimento x,y;
    

    
    public Calculo(float IMS, float PB,float NDT){
        
        this.setIMS(IMS);
        this.setPB(PB);
        this.setNDT(NDT);
        EspacoReserva();
    }
            
    public void setIMS(float IMS){
        this.IMS = IMS;
    }        
    public void setPB(float PB){
        this.PB = PB;
    }
    public void setNDT(float NDT){
        this.NDT = NDT;
    }
    public float getIMS(){
        return this.IMS;
    }
    public float getPB(){
        return this.PB;
    }
    public float getNDT(){
        return this.NDT;
    }
     Alimento alimentos(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("ims"+getIMS()+"pb"+getPB()+"ndt"+getNDT());
        
        System.out.println("Digite nome aliemnto :");
        String nome = scan.nextLine();
       
        System.out.println("Digite ndt aliemnto :");
        float ndt = scan.nextFloat();
        System.out.println("Digite pb aliemnto :");
        float pb = scan.nextFloat();
        
        Alimento alim = new Alimento(nome,pb,ndt);
        
        return alim;
    }
    
    public void inicializa(){
        //System.out.println("Quantos Alimentos quer colocar no calculo");
    }
    
    //função que ajust o espaço reserva
    //ajuste dos 3%
    public void EspacoReserva(){
        //-3%
        this.IMS = (float) (this.IMS- (this.IMS * 0.03));
        //+3
        this.PB = (float) (this.PB + (this.PB*0.03));
        this.NDT= (float) (this.NDT + (this.NDT*0.03));
    }
    
    

   
    //provavelmente passa os objeto alimento como parametro
    //ou passa o objeto vetor alimento
    //função para alinhamento de PB
    public boolean QuadradoPearson(){
        
        
        if(aux<2){

            Alimento  x = alimentos();
            Alimento  y = alimentos();
            System.out.println("Alimentos: ");
            System.out.println("--------------------------------");
            System.out.println("nome: "+x.getNome());
            System.out.println("ndt: "+x.getNDT());
            System.out.println("pb: "+x.getPB());
            System.out.println("-------------------------------");
            System.out.println("nome: "+y.getNome());
            System.out.println("ndt: "+y.getNDT());
            System.out.println("pb: "+y.getPB());



            float Partes_1,Partes_2,Partes_total;
            //realiza o quadrado 
            Partes_1 = Math.abs(y.vPB - PB);
            Partes_2 = Math.abs(x.vPB - PB);

            Partes_total = Partes_1+Partes_2;
            //realiza a porcentagem
            //em casa de o.80 = 80%
            porcQ_PB1 = (Partes_1 /Partes_total);
            porcQ_PB2 = (Partes_2 /Partes_total);
            
            EstruturaAcoplacao est = new EstruturaAcoplacao(x,porcQ_PB1);
            TADalimento.add(est);
            est = new EstruturaAcoplacao(y,porcQ_PB2);
            TADalimento.add(est);
            //falta parte das aceitações do NDT IF
            float addndt = x.vNDT*porcQ_PB1 +y.vNDT*porcQ_PB2;
            System.out.println(NDTajustado.size());
            NDTajustado.add(addndt);
            System.out.println(NDTajustado.size());
            System.out.println(NDTajustado.get(0));
            //sempre se ajusta automatico  
            float addpb = 100 - (float) NDTajustado.get(contador);
            //------------------------------------------------------------------------PBajustado.add(addpb);
            System.out.println(NDTajustado.get(contador));
            //ndt fixo
            float NDTfajustado =(float) NDTajustado.get(contador);
            //-------------------------------------------------------------------------System.out.println(PBajustado.get(contador));
            //testa se o  PB esta dentro da faixa de erro
            if(aceitoNDT(NDTfajustado) == true && aux == 0){
                Baceito = true;
                ajustoundt = true;
                aceite = true;
                
                return true;
                
                 //finalisa
                 //chama metodo passando ndt e pb 
            }
            else{
                if(NDTfajustado>this.NDT && maior == 0){
                    Bmaior = true;
                    maior = NDTfajustado;
                    System.out.println("maior: "+maior);
                }
                else{
                    System.out.println("2 valores maiores quando vai abrir o ndt");
                }
                if(NDTfajustado<this.NDT && menor == 0){
                    Bmenor = true;
                    menor = NDTfajustado;
                    System.out.println("menor: "+menor);
                }
                else{
                    System.out.println("2 valores menores quando vai abrir o ndt");
                }

                if(maior != 0 && menor != 0){
                    //completa fechamento
                    System.out.println("menor"+menor);
                    System.out.println("maior"+maior);
                    aceite = true;
                    return true;

                }
                aux++;
                contador++;
                QuadradoPearson();
            }
                
        }
       
        return aceite;
    }
    
    
    public boolean aceitoNDT(float ndt){
        
        return ndt<Taxa_erro_NDT + this.NDT && this.NDT-Taxa_erro_NDT<ndt;
    
    }
    //provavelmente passa os objeto alimento como parametro
    //ou passa o objeto vetor alimento

    public boolean QuadradoPearsonNDT(){   
        //realiza o quadrado 
        float Partes_1,Partes_2,Partes_total;
        
        
        Partes_1 = Math.abs(menor - this.NDT);
        Partes_2 = Math.abs(maior - this.NDT);
        System.out.println("partes alim 1: "+Partes_1);
        System.out.println("partes alim 2: "+Partes_2);
        Partes_total = Partes_1 + Partes_2;
        
        porcQ_NDT1 = Partes_1/Partes_total;
        porcQ_NDT2 = Partes_2/Partes_total;
        ajustoundt = true;
        
        System.out.println("porc alim 1: "+porcQ_NDT1);
        System.out.println("porc alim 2: "+porcQ_NDT2);
        
        return true;
        
      
    }
    
    /*
    public void rEspacoReserva(float a,float b,float c,float d){
        a = a * (float)0.97;
        b = b * (float)0.97;
        c = c * (float)0.97;
        d = d * (float)0.97;
    }
    */
    
    public void rEspacoReserva(){
        aux1 = aux1 * (float)0.97;
        aux2 = aux2 * (float)0.97;
        aux3 = aux3 * (float)0.97;
        aux4 = aux4 * (float)0.97;
        
    }
    public boolean FechaCalc(){
        
        boolean bool;
        
        if (!(Baceito)){
            if(Bmenor&&Bmaior){
            QuadradoPearsonNDT();
            System.out.println("passo no quadrado ndt else fecha calc");
            System.out.println(TADalimento);
            
            porcQ_NDT1 = porcQ_NDT1*100;
            porcQ_NDT2 = porcQ_NDT2*100;
            
            
            aux1 =  porcQ_NDT1*TADalimento.get(0).getPorcAlim_pQ();
            aux2 =  porcQ_NDT1*TADalimento.get(1).getPorcAlim_pQ();
            aux3 =  porcQ_NDT2*TADalimento.get(2).getPorcAlim_pQ();
            aux4 =  porcQ_NDT2*TADalimento.get(3).getPorcAlim_pQ();
            
            rEspacoReserva();
            
            TADalimento.get(0).setPorcFinal(aux1);
            TADalimento.get(1).setPorcFinal(aux2);
            TADalimento.get(2).setPorcFinal(aux3);
            TADalimento.get(3).setPorcFinal(aux4);
            System.out.println(TADalimento);
            System.out.println("Espaço Reserva :"+3.0);
            /*EstruturaAcoplacao aux = new EstruturaAcoplacao();
            TADalimento.set(0, element);
            TADalimento.get(1).setPorcFinal(porcQ_NDT1*TADalimento.get(1).getPorcAlim_pQ());
            TADalimento.get(2).setPorcFinal(porcQ_NDT2*TADalimento.get(2).getPorcAlim_pQ());
            TADalimento.get(3).setPorcFinal(porcQ_NDT2*TADalimento.get(3).getPorcAlim_pQ());
            
            System.out.println(TADalimento);
                
            
            
            
            
            
            
            
            System.out.println("");
            System.out.println("");
            System.out.println("");
            */
            bool = true;
            return true;
            }
            else{
            System.out.println("Bmenor"+Bmenor+"/"+"Bmaior"+Bmaior+"/"+"Baceito"+Baceito+"/");
            System.out.println("Calculo não pode ser realizado");
            //possivelmente chama a função do calculo de novo
            bool = false;
            return false;
            }
            
        }
        else{
            //modelo do finalizou direto
            System.out.println("Caso especial roda 1 vez");
            bool = true;
                
        }
        
        return bool;           
            
    }
}
    
    


