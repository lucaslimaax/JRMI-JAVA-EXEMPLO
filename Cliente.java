package rmi;

import java.rmi.Naming;

public class Cliente {
    public static void main(String[] args) {
        System.out.println("Cliente rodando");
        try {
            RMI meuObjeto = (RMI) Naming.lookup("//10.180.199.8/obj");
            System.out.println(meuObjeto.financiamento(100000, 60000, 36));
            System.out.println(meuObjeto.seguro(100000, 2005, "leste"));
              
        } catch (Exception e) {
            System.err.println("Falha ao \"puxar\" o objeto remoto");
        }    
        
    }
}
