package rmi;

import java.rmi.Remote;

public interface RMI extends Remote {

   public String financiamento(float valor, float entrada, int meses ) throws Exception;
   public String seguro(float valor, int ano, String regiao )throws Exception;
       
}
