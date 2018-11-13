package rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends UnicastRemoteObject implements RMI {
    
    public static void main(String[] args) {
        
        System.out.println("SERVIDOR ativo...");
        try {
            System.setProperty("java.rmi.server.hostname", "10.180.199.8");
            LocateRegistry.createRegistry(1099);
            Naming.rebind("//10.180.199.8/obj", new Servidor());

        } catch (Exception e) {
            System.err.println("Falha ao subir o servidor");
        }
    }
    
    public Servidor() throws Exception {}

    @Override
    public String financiamento(float valor, float entrada, int meses) throws Exception {
        
         float parcela=0;
        
        if(entrada>=(valor/2)){
           valor-=entrada;
            valor=valor*1.35F;
           parcela=valor/meses;   
        }
        
         if(entrada<=(valor/2)){
           valor-=entrada;
            valor=valor*1.45F;
           parcela=valor/meses;   
        }
         
     return "O valor da parcela eh: "+parcela+" em "+meses+". Valor financiado: "+valor;
    }
    
    
  @Override
  
   public String seguro(float valor, int ano, String regiao)throws Exception{
       
       if(ano<=2005){
           valor=valor*1.15F;
       }
       
        if(ano>=2006&&ano<=2014){
           valor=valor*1.10F;
       }
        if(ano>2014){
             valor=valor*1.05F;
        }
        if(regiao.equals("sul")){
            valor+=500F;
            
        }
        
         if(regiao.equals("leste")){
            valor+=600F;
            
        }
         if(regiao.equals("norte")){
            valor+=250F;
            
        }
         if(regiao.equals("oeste")){
            valor+=350F;
            
        }
     return "O valor do seguro do carro sera de: "+valor;   
   }
  
    
}//fim rmi

