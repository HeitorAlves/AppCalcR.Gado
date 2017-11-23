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
    float espacoReserva,espacoPorcentagem;
    

    
    ArrayList<Alimento> ListaAlimentos = new ArrayList<>();
    
    
    
    
    ArrayList<EstruturaAcoplacao> TADalimento = new ArrayList<>();
    //start
    float IMS,PB,NDT;
    ArrayList NDTajustado = new ArrayList();
    ArrayList PBajustado = new ArrayList();
    int Taxa_erro_PB = 2,Taxa_erro_NDT =2;
    //É as variaveis modulo x e y subtraidas das variaveis 
    
    //aux fecha calc
    float aux1,aux2,aux3,aux4;
    
    float porcQ_NDT1, porcQ_NDT2;
    float porcQ_PB1,porcQ_PB2;
    //variaveis do quadrado
    //provavel vai virar 2 objetos
    //float item_1,item_2;
    Alimento x,y;
    

    public Calculo(){}
    
    public Calculo(float IMS, float PB,float NDT){
        
        this.setIMS(IMS);
        this.setPB(PB);
        this.setNDT(NDT);
        
    }
    
    public void iniciaListaAlimento(){
        Alimento aux1 = null,aux2 = null,aux3 = null,aux4 = null;
       
        ListaAlimentos.add(aux1);
        ListaAlimentos.add(aux2);
        ListaAlimentos.add(aux3);
        ListaAlimentos.add(aux4);
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
    
    public void inicializa(){
        
        
        Scanner entradaF = new Scanner(System.in);
        Scanner entradaI = new Scanner(System.in);
        Scanner entradaS = new Scanner(System.in);
        System.out.println("IMS"+getIMS()+"PB"+getPB()+"NDT"+getNDT());
        System.out.println("|---------------------------------------------------|");
        System.out.println("|---------------------Calc.R.Gado-------------------|");
        System.out.println("|1_Para entrar com alimentos                        |");
        System.out.println("|2_Para entrar com espaço reserva                   |");
        System.out.println("|3_Calcular                                         |");
        System.out.println("|---------------------------------------------------|");
        int h = entradaI.nextInt();
        int nAlimentos;
        System.out.println("|------------Confirma(S/N)--------------------------|");
        String confirmacao = entradaS.nextLine();
        if("S".equals(confirmacao)){
            switch(h){
                case 1:
                    System.out.println("|1_Para entrar com alimentos                        |");
                    System.out.println("|Digite a quantidade de Alimentos ");
                    nAlimentos = entradaI.nextInt();
                    if(nAlimentos<4){
                        InsercaoAlimMS(nAlimentos);
                        
                    }
                    else{
                        InsercaoAlimMC();
                    }
                    inicializa();
                    break;
                case 2:
                    System.out.println("Digite o valor do Espaço Reserva");
                    System.out.println("Valaores Inteiros Ex: 1/1%,2/2%,3/3%..");
                    espacoReserva = entradaF.nextFloat();
                    espacoPorcentagem = espacoReserva/100;
        
                    EspacoReserva(espacoPorcentagem);
                    inicializa();
                    break;
                case 3:
                    
                    if(QuadradoPearson()){
                        if(FechaCalc()){
                            System.out.println("calculo concluido");
                        }
                        else{
                            System.out.println("erro no quadrado");
                        }
                    }
                    break;

            }
        }else{
            inicializa();
        }
        
        //System.out.println("Quantos Alimentos quer colocar no calculo");
    }
    
    
    public void InsercaoAlimMC(){};
        
    public void InsercaoAlimMS(int nAlimentos){
        if(nAlimentos <3){
            System.out.println("Erro numero de alimentos menor que a entrada minima");
        }
        else{
            for(int i = 0; i<nAlimentos;i++){
                ListaAlimentos.add(DadosAlimentos());
            }
            ordenaListaAlim(ListaAlimentos);
            CompletaAlimQuadrado();
            
            System.out.println("Lista de Alimentos");
            for (int i = 0; i < nAlimentos; i++) {
                System.out.println(ListaAlimentos.get(i).nome);
                
            }
        }
        
    }
    
    //recebe 3 alimentos e ordena de forma a realização do calculo ser possivel
    public void ordenaListaAlim(ArrayList<Alimento> listaAlimentos){
        if(listaAlimentos.get(0).vPB>PB && listaAlimentos.get(1).vPB>PB){
            if(listaAlimentos.get(2).vPB>PB){
                System.out.println("Alimentos Impossivel de Realizar calculo");
            }
            else{
                Alimento aux1 = listaAlimentos.get(1);
                Alimento aux2 = listaAlimentos.get(2);
                listaAlimentos.set(1, aux2);
                listaAlimentos.set(2, aux1);
                
            }
        }
        if(listaAlimentos.get(0).vPB<PB && listaAlimentos.get(1).vPB<PB){
            if(listaAlimentos.get(2).vPB<PB){
                System.out.println("Alimentos Impossivel de Realizar calculo");
            }
            else{
                Alimento aux1 = listaAlimentos.get(1);
                Alimento aux2 = listaAlimentos.get(2);
                listaAlimentos.set(1, aux2);
                listaAlimentos.set(2, aux1);
                
            }
                
            
        }
        
    }
    
    void CompletaAlimQuadrado(){
        Alimento alimentoAux;
        
        alimentoAux = ListaAlimentos.get(2);
        System.out.println(alimentoAux);
        System.out.println(PB);
        //preenche procurando valor de pb menor pro ultimo alimento
        if(alimentoAux.vPB>PB){
             System.out.println("birlpai");
            setquartoAlim(1);
        }
        //preenche procurando valor de pb maior pro ultimo alimento
        else{
            System.out.println("herepai");
            setquartoAlim(0);
        }
    }
    
    void setquartoAlim(int maiormenor){
        //add ultimo alimento com pb menor que o seu par
        if(maiormenor == 1){
            System.out.println("birl");
            for(int i=0;i<ListaAlimentos.size()-1;i++){
                if(ListaAlimentos.get(i).vPB<PB){
                    ListaAlimentos.add(ListaAlimentos.get(i));
                }
            }
        }
        //add ultimo alimento com pb maior que o seu par
        if(maiormenor == 0){
            System.out.println("here");
            for(int i=0;i<ListaAlimentos.size()-1;i++){
                System.out.println(ListaAlimentos.get(i));
                 if(ListaAlimentos.get(i).vPB>PB){
                     System.out.println("aqui"+ListaAlimentos.get(i));
                    ListaAlimentos.add(ListaAlimentos.get(i));
                }
            }
        }
    }
    
    
    Alimento DadosAlimentos(){
        Scanner scan = new Scanner(System.in);
        
        
        
        System.out.println("Digite nome aliemnto :");
        String nome = scan.nextLine();
        System.out.println("Digite PB aliemnto :");
        float pb = scan.nextFloat();
        System.out.println("Digite NDT aliemnto :");
        float ndt = scan.nextFloat();
        
        
        Alimento alim = new Alimento(nome,pb,ndt);
        
        return alim;
    }
    

    //função que ajust o espaço reserva
    //ajuste dos 3%
    public void EspacoReserva(float espacoPorcentagem){
        //-3%
        
        this.IMS = (float) (this.IMS- (this.IMS * espacoPorcentagem));
        //+3
        this.PB = (float) (this.PB + (this.PB*espacoPorcentagem));
        this.NDT= (float) (this.NDT + (this.NDT*espacoPorcentagem));
    }
    
    

   
    //provavelmente passa os objeto alimento como parametro
    //ou passa o objeto vetor alimento
    //função para alinhamento de PB
    public boolean QuadradoPearson(){
        
        
        if(aux<2){
            /*System.out.println("ims"+getIMS()+"pb"+getPB()+"ndt"+getNDT());

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
            */

            
            x = ListaAlimentos.get(0);
            y = ListaAlimentos.get(1);
            
            if(aux == 1){
            x = ListaAlimentos.get(2);
            y = ListaAlimentos.get(3);
            }
            
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
    
    


