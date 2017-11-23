
import java.util.ArrayList;


public class MistTeste {


    public static void main(String[] args) {
       
        ArrayList<Alimento> list = new ArrayList();
        ArrayList auxiliar = new ArrayList();
        
        //Alimento a = new alimento(nome,pb,ndt);
        Alimento a1 = new Alimento ("1_Farelo de Soja",           48.75f, 80.48f);
        Alimento a2 = new Alimento ("2_Milho Fubá",               9.04f,  85.73f);
        Alimento a3 = new Alimento ("3_Polpa Cítrica",            8f,     77f);
        Alimento a4 = new Alimento ("4_Caroço de algodão",        22.4f,  96f);
        Alimento a5 = new Alimento ("5_Farelo de Trigo",          18.5f,  70f);
        Alimento a6 = new Alimento ("6_Casca de Soja",            13.8f,  77f);
        Alimento a7 = new Alimento ("7_Farelo de algodão",        44.8f,  75f);
        Alimento a8 = new Alimento ("8_Farelo de Girassol",       25.9f,  44f);
        Alimento a9 = new Alimento ("9_Cana-de-Açucar",           2.4f,   60f);
        Alimento a10 = new Alimento("10_Silagem de Milho",         8.1f,   70f);
        Alimento a11 = new Alimento("11_Alfafa",                   7f,     58f);
        Alimento a12 = new Alimento("12_Feno de gramineas",        5.8f,   40f);
        Alimento a13 = new Alimento("13_Pasto Capim Elefante",     12f,    55f);
        Alimento a14 = new Alimento("14_Resínduo de Cervejaria",   29.2f,  66.0f);
        
        list.add(a1);
        //list.add(a2);
        //list.add(a3);
        //list.add(a4);
        /*list.add(a5);
        list.add(a6);
        list.add(a7);
        list.add(a8);
        list.add(a9);
        list.add(a10);
        list.add(a11);
        list.add(a12);
        list.add(a13);
        list.add(a14);*/

        System.out.println(list);           
        
        
        /*float div = list.get(1).vPB+list.get(11).vPB+list.get(12).vPB+list.get(8).vPB;
        float valor = 14.83f;
        float res = valor/div;
        float i = 5;
        while(i<14.83){
            System.out.println("i"+i+"\n");
            auxiliar.add(i/div);
            i = i + 0.1f;
        }
        System.out.println("auxiliar"+auxiliar);
        System.out.println(res);
        float aux1 = list.get(1).getPB()*res;
        float aux2 = list.get(11).getPB()*res;
        float aux3 = list.get(12).getPB()*res;
        float aux4 = list.get(8).getPB()*res;
        
        System.out.println("aux1"+aux1);
        System.out.println("aux2"+aux2);
        System.out.println("aux3"+aux3);
        System.out.println("aux4"+aux4);
        
        float resultado = aux1+aux2+aux3+aux4;
        
        if (res == resultado){
            System.out.println("True");
        }
        else{
            System.out.println("res"+res);
            System.out.println("resultado"+resultado);
        }*/
        System.out.println("-------------------------------------------------");
        ArrayList<Float>  porcNegada = new ArrayList<>();
        ArrayList<Float> porcGerada = new ArrayList<>();
        float PB = 14.83f;
        float NDT = 71.9f;
        
        
        float auxPB = 0;
        for(Alimento cont : list){
            auxPB = auxPB + cont.vPB;
            System.out.println("h"+auxPB);
        }
        float w = PB-5;
        while(w<PB){
        porcGerada.add(w/auxPB);
        System.out.println(porcGerada);
        w = w + 0.01f;
        }
          System.out.println("________________-__");
        System.out.println(porcGerada);
        
        Alimento x = mePbmeNDT(list,PB,NDT,porcNegada,porcGerada);
        System.out.println("alimento"+x);
        System.out.println("negada"+porcNegada);
        System.out.println("aceito"+porcGerada);
        
    }
    
        public static Alimento mePbmeNDT(ArrayList<Alimento> list, float PB, float NDT, ArrayList porcNegada,ArrayList porcGerada){
        //variavel de repetição
        boolean aceito = false;
        //variavel para retorno
        Alimento complexo = new Alimento("",0,0);
        

        //deleta porcentagens invalidas para NDT
        /*for(Object cont :porcNegada){
            for(Object cont1 :porcGerada){
                if(porcNegada.equals(porcGerada)){
                    porcGerada.remove(cont1);
                }
            }
            
        }*/
        int cont = 0;
            System.out.println("oi");
        //repetição para achar valor que atende pb e ndt menores
        while(aceito != true){
            System.out.println("cont"+cont);
            float auxResPB = 0;
            float auxResNDT = 0;
        
        
            for(Alimento i : list){
                System.out.println("i.vpb"+i.vPB);
                System.out.println("i.vndt"+i.vNDT);
                auxResPB = auxResPB+ i.vPB*(float)porcGerada.get(0);
                auxResNDT = auxResNDT + i.vNDT*(float)porcGerada.get(0);
            }
            System.out.println("aux pb"+ auxResPB);
            System.out.println("aux ndt"+auxResNDT);
            if(auxResNDT>NDT){
                System.out.println("true");
                complexo.setNDT(auxResNDT);
                System.out.println("aux"+auxResNDT);
                complexo.setPB(auxResPB);
                complexo.setNome("Mistura mePmeN");
                aceito = true;
            }
            else{
                System.out.println("nega");
                cont++;
                porcNegada.add(porcGerada.get(0));
                porcGerada.remove(0);

            }
        }
        
    return complexo;
    }
    
}
