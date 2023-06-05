import java.util.Scanner;
public class Ejecucion {
    public static int posicion=0;

    public static void crearCuentaAhorro(Scanner entrada, Cuenta [] cta){
        int dc=-1; int num_cta;String titular_cta; float saldo_actual; float aho_meta; char estado;
        int ind=0;
        do{
            System.out.println("\nCREACION DE CUENTAS DE AHORRO");
            System.out.println("*******************************************");
            System.out.print("INGRESE NUMERO CUENTA: ");
            num_cta=entrada.nextInt();
            System.out.print("INGRESE TITULAR CUENTA: ");
            titular_cta= entrada.next();
            System.out.print("INGRESE SALDO ACTUAL: ");
            saldo_actual= entrada.nextFloat();
            System.out.print("INGRESE AHORRO META: ");
            aho_meta=entrada.nextFloat();
            estado='A';
            cta[ind]= new  Ahorro(num_cta, titular_cta, saldo_actual, estado, aho_meta, aho_meta);
            ind++;
            System.out.println("DATOS GRABADOS CORRECTAMENTE...........");
            System.out.print("DIGITE [1] PARA CONTINUAR - DIGITE [2] PARA SALIR AL MENU: ");
            dc=entrada.nextInt();
            System.out.println(dc);
        }while(dc==1);
    }

    public static void crearCuentaCorriente(Scanner entrada, Cuenta [] cta){
        int dc=-1; int num_cta;String titular_cta; float saldo_actual; char estado;
        String of_cred;
        int ind=0;
        do{
            System.out.println("\nCREACION DE CUENTAS CORRIENTES");
            System.out.println("*******************************************");
            System.out.print("INGRESE NUMERO CUENTA: ");
            num_cta=entrada.nextInt();
            System.out.print("INGRESE TITUTLAR CUENTA: ");
            titular_cta= entrada.next();
            System.out.print("INGRESE SALDO ACTUAL: ");
            saldo_actual= entrada.nextFloat();
            System.out.print("INGRESE OFICIAL DE CREDITO: ");
            of_cred=entrada.next();
            estado='A';
            cta[ind]= new  Corriente(num_cta, titular_cta, saldo_actual, estado, 0, of_cred);
            ind++;
            System.out.println("DATOS GRABADOS CORRECTAMENTE...........");
            System.out.print("DIGITE [1] PARA CONTINUAR - DIGITE [2] PARA SALIR AL MENU: ");
            dc=entrada.nextInt();
        }while(dc==1);
    }

    public static void consultarSaldos(Cuenta [] cta){
        System.out.println("\nCONSULTANDO SALDOS DE LAS CUENTAS");
        for(int i=0; i<cta.length;i++){
            System.out.println("TIPO CUENTA: "+ cta[i].getClass().getName() + "TITULAR: "+cta[i].getTitular()+ " SALDO: "
            +cta[i].getSaldo_actual());
        }
    }

    public static void generarInteres(Cuenta [] cta){
        System.out.println("\nGENERANDO INTERES DE LAS CUENTAS......");
        for(int i =0; i<cta.length;i++){
            System.out.println("TIPO DE CUENTA: "+cta[i].getClass().getName()+ " TITULAR: "+cta[i].getTitular()+ " INTERES: "+cta[i].generarInteres());
            cta[i].setSaldo_actual(cta[i].getSaldo_actual() + cta[i].generarInteres());
            System.out.println("SALDO ACTUAL: " + cta[i].getSaldo_actual());
        }
    }

    public static void depositoAhorro(Cuenta [] cta){
        Scanner entrada = new Scanner(System.in); float valor_deposito;
        int numero_cuenta, indice=0, posicion=-1; boolean encontrado= false; 
        System.out.println("\nDEPOSITO DE AHORRO");
        System.out.println("****************************************");
        System.out.print("INGRESE EL NUMERO DE LA CUENTA: ");
        numero_cuenta= entrada.nextInt();
        while(indice<cta.length && encontrado == false){
            if(cta[indice].getNumero()==numero_cuenta){
                posicion= indice; 
                encontrado= true; 
            }
            indice++;
        }
        if(encontrado == true){
            System.out.println("TITULAR: "+cta[posicion].getTitular());
            System.out.print("INGRESAR EL VALOR DEL DEPOSITO: ");
            valor_deposito=entrada.nextFloat();
            cta[posicion].setSaldo_actual(valor_deposito+cta[posicion].getSaldo_actual());
            System.out.println("SALDO ACTUAL ACTUALIZADO: "+cta[posicion].getSaldo_actual());
            System.out.println("\nDEPOSITO REALIZADO CON EXITO.....");
        }
        else{
            System.out.println("\nLA CUENTA NO EXISTE............");
        }
    }

    public static void depositoCorriente(Cuenta [] cta){
        Scanner entrada = new Scanner (System.in); float deposito_corriente;
        int num_cuenta_corriente, indice = 0 , posicion_corriente=-1; boolean encontrado_corriente= false; 
        System.out.println("\n\tDEPOSITO EN LA CUENTA CORRIENTE.............");
        System.out.println("************************************");
        System.out.print("INGRESE EL NUMERO DE LA CUENTA: ");
        num_cuenta_corriente= entrada.nextInt();
        while(indice<cta.length && encontrado_corriente==false){
            if(cta[indice].getNumero()==num_cuenta_corriente){
                posicion_corriente=indice;
                encontrado_corriente=true;
            }
            indice++;
        }
        if(encontrado_corriente==true){
            System.out.println("TITULAR: "+cta[posicion].getTitular());
            System.out.print("INGRESE EL VALOR A DEPOSITAR: ");
            deposito_corriente= entrada.nextFloat();
            cta[posicion].setSaldo_actual(deposito_corriente+cta[posicion_corriente].getSaldo_actual());
            System.out.println("SALDO ACTUALIZADO: "+cta[posicion].getSaldo_actual());
            System.out.println("\nDEPOSITO REALIZADO CON EXITO..........");
        }
        else{
            System.out.println("\nLA CUENTA NO EXISTE.............");
        }
    }

    public static void retirarAhorro(Cuenta cta[]){
        Scanner entrada = new Scanner(System.in); int retiro_deposito;
        int numero_cuenta, indice=0, posicion=-1; boolean encontrado= false; 
        System.out.println("RETIRO EN LA CUENTA DE AHORRO");
        System.out.println("****************************************");
        System.out.print("INGRESE EL NUMERO DE LA CUENTA: ");
        numero_cuenta= entrada.nextInt();
        while(indice<cta.length && encontrado == false){
            if(cta[indice].getNumero()==numero_cuenta){
                posicion= indice; 
                encontrado= true; 
            }
            indice++;
        }
        if(encontrado == true){
            System.out.println("TITULAR: "+cta[posicion].getTitular());
            System.out.print("INGRESAR EL VALOR DEL RETIRO:  ");
            retiro_deposito=entrada.nextInt();
            if((retiro_deposito<0)&(retiro_deposito<cta[posicion].getSaldo_actual())|(retiro_deposito<=cta[posicion].getAhorrometa())){
                System.out.println("NO SE HA REALIZADO EL RETIRO......");
            }else{
                cta[posicion].setSaldo_actual(cta[posicion].getSaldo_actual()-retiro_deposito);
                System.out.println("SALDO : "+cta[posicion].getSaldo_actual());
                System.out.println("\nRETIRO REALIZADO CON EXITO.....");
            } 
        }else{
            System.out.println("\nLA CUENTA NO EXISTE............");
        }
    }
    
    public static void retirarCorrientes(Cuenta cta[]){
        Scanner entrada = new Scanner (System.in); int retiro_corriente;
        int cuenta_corriente, indice = 0 , posicion_corriente=-1; boolean encontrado_corriente= false; 

        System.out.println("\t\t\tRETIRO EN LA CUENTA CORRIENTE\t\t\t\n");
        System.out.println("************************************");
        System.out.print("INGRESE EL NUMERO DE LA CUENTA: ");
        cuenta_corriente= entrada.nextInt();
        while(indice<cta.length && encontrado_corriente==false){
            if(cta[indice].getNumero()==cuenta_corriente){
                posicion_corriente=indice;
                encontrado_corriente=true;
            }
            indice++;
        }
        if(encontrado_corriente==true){
            System.out.println("TITULAR: "+cta[posicion].getTitular());
            System.out.print("INGRESE EL VALOR A RETIRAR: ");
            retiro_corriente= entrada.nextInt();
            if(cta[posicion_corriente].getSaldo_actual()<1000){
                System.out.println("NO SE REALIZO EL RETIRO...");
                cta[posicion_corriente].setEstado('I');
                System.out.println("EL ESTADO DE LA CUENTA "+cta[posicion_corriente].getEstado()+" INACTIVA");
            }else if(cta[posicion_corriente].getSaldo_actual() >1000){
                cta[posicion_corriente].setEstado('A');
                System.out.println("\nEL ESTADO DE LA CUENTA ES: "+cta[posicion_corriente].getEstado()+" ACTIVA");
                System.out.print("DIGITE EL VALOR A RETIRAR DE LA CUENTA: ");
                retiro_corriente= entrada.nextInt();
                if(retiro_corriente<=0){
                    System.out.println("NO SE REALIZO EL RETIRO");
                    System.out.println("ES UN VALOR NEGATIVO");
                }else if(retiro_corriente>cta[posicion_corriente].getSaldo_actual()){
                    System.out.println("\nNO SE REALIZO EL RETIRO");
                    System.out.println("EL RETIRO ES SUPERIOR AL SALDO ACTUAL");
                }else if(retiro_corriente>cta[posicion_corriente].getSaldo_actual()){
                    cta[posicion].setSaldo_actual(cta[posicion_corriente].getSaldo_actual()-retiro_corriente);
                    System.out.println("SALDO ACTUALIZADO: "+cta[posicion_corriente].getSaldo_actual());
                }
            }
        }else{
            System.out.println("\nLA CUENTA NO EXISTE...........");
        }
    }

    public static void menuPrincipal(Scanner entrada, Cuenta [] cta){
        System.out.println("      \nMENU PRINCIPAL      ");
        System.out.println("-------------------------");
        System.out.println("1.APERTURAR CUENTA AHORRO");
        System.out.println("2.APERTURAR CUENTA CORRIENTE");
        System.out.println("3.DEPOSITO EN CUENTA AHORRO");
        System.out.println("4.DEPOSITO EN CUENTA CORRIENTE");
        System.out.println("5.RETIRAR EN CUENTA AHORRO");
        System.out.println("6.RETIRAR EN CUENTA CORRIENTE");
        System.out.println("7.CONSULTAR SALDOS DE CUENTAS");
        System.out.println("8..GENERAR INTERES");
        System.out.println("9.SALIR");
        System.out.print("DIGITE UNA OPCION: ");
        int opcion = entrada.nextInt();
        switch(opcion){
            case 1: crearCuentaAhorro(entrada, cta); menuPrincipal(entrada, cta);break;
            case 2: crearCuentaCorriente(entrada, cta);menuPrincipal(entrada, cta);break;
            case 3: depositoAhorro(cta); menuPrincipal(entrada, cta); break;
            case 4: depositoCorriente(cta); menuPrincipal(entrada, cta);break;
            case 5: retirarAhorro(cta); menuPrincipal(entrada, cta);break;
            case 6: retirarAhorro(cta);menuPrincipal(entrada, cta); break; 
            case 7: consultarSaldos(cta);menuPrincipal(entrada, cta);break;
            case 8:generarInteres(cta); menuPrincipal(entrada, cta);break;
        }
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        final int MAX=2;
        Cuenta [] cta = new Cuenta[MAX];
        menuPrincipal(entrada, cta);
    }   
}
