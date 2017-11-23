import java.util.Scanner;
        
public class Main {

    public static void main(String[] args) {
    /*    float IMS,PB,NDT;
        Scanner entrada = new Scanner(System.in);
        String resposta = null;
        System.out.println("Digite os valores para os seguintes itens: IMS,NDT,PB");
        System.out.println("IMS: ");
        IMS = entrada.nextFloat();
        System.out.println("NDT: ");
        NDT = entrada.nextFloat();
        System.out.println("PB: ");        
        PB = entrada.nextFloat();
        
        Calculo z = new Calculo(IMS,PB,NDT);       
        if(exec(z)){
            System.out.println("Concluido Calculo");
            return;
        }
        else{
            //erro ao realizar calculo reinicia calculo
            System.out.println("Erro ao realizar quadrado");
            System.out.println("Deseja realizar uma nova tentativa ? (sim/nao):");
            resposta = entrada.nextLine();
             
            if(compara(resposta.toLowerCase(),"sim") == true){
                   exec(z);
                   System.out.println("???"); 
                   exec(z);
            }
            else
            {
                System.out.println("fim de execução");
                return;
            }


        }
    }
        
    
    public static boolean compara(String entrada, String asercomparada){
        return (entrada.equals(asercomparada));
    }
    
    public static boolean exec(Calculo parametros){
        
        if(parametros.QuadradoPearson()){
            if(parametros.FechaCalc()){
                return true;
            }
        }
        return false;
    }
    
*/
        
     float IMS,PB,NDT;
        Scanner entrada = new Scanner(System.in);
        String resposta = null;
        System.out.println("Digite os valores para os seguintes itens: IMS,NDT,PB");
        System.out.println("IMS: ");
        IMS = entrada.nextFloat();
        System.out.println("PB: ");        
        PB = entrada.nextFloat();
        System.out.println("NDT: ");
        NDT = entrada.nextFloat();
        
        
        Calculo z = new Calculo(IMS,PB,NDT);
        z.inicializa();
        
     
    }
}
