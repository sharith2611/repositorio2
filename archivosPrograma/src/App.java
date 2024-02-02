import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner=new Scanner(System.in);
        int opcion;
        ArrayList <Banco> bancos= new ArrayList<>();
        Banco banco1=new Banco("Sena");
        bancos.add(banco1);
        Cliente cliente1=new Cliente(55242755, "Yudis");
        Cliente cliente2=new Cliente(1044613766, "Sharith");
        Cliente cliente3=new Cliente(1044613756,"Omar");
        cliente1.CrearCuentaCliente(030025,300.0 , "Ahorro", cliente1);
        cliente2.CrearCuentaCliente(25536, 200.0, "Ahorro", cliente2);
        cliente3.CrearCuentaCliente(3556, 400.0, "Corriente", cliente3);
        banco1.adicionarCliente(cliente1);
        banco1.adicionarCliente(cliente2);
        banco1.adicionarCliente(cliente3);

        do {
            System.out.print("--------MENU-------\n"+
            "1. Crear/cambiar nombre Banco \n"+
            "2. Agregar Cliente a un Banco \n"+
            "3. Ver información clientes \n"+
            "4. Ver saldos totales cuentas de ahorros \n"+
            "5. Ver saldos totales cuentas corrientes \n"+
            "6. Salir\n" + 
            "Digite opcion: ");
            opcion= scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("--------MENU-------\n"+
                                          "1.Crear Banco \n"+
                                          "2.Cambiar nombre Banco \n"+
                                          "3.Salir\n"+
                                          "Digite opcion: ");

                    int opcion1=scanner.nextInt();
                    switch (opcion1) {
                        case 1:
                        System.out.print("Digite nombre del Banco: ");
                        String nombre=scanner.next();
                        if (bancos.size()!=0 && nombre!="0") {
                         for (Banco banco : bancos) {
                         if (nombre.equals(banco.getNombre())&& nombre!="0") {       
                                    System.out.print("Este banco ya existe ");
                                    break;
                                }else{
                                    if (nombre=="0") {
                                    break;}
                                    bancos.add(new Banco(nombre));
                                    System.out.println("Banco creado con exito");
                                    break;
                                }
                        }
                    } else{
                         bancos.add(new Banco(nombre));
                         System.out.println("Banco creado con exito");
                        break;
                    } 

                        case 2:
                            for (Banco banco : bancos) {
                            System.out.print("Digite nombre del Banco a cambiar: ");
                            String nombreAntiguo=scanner.next();
                            if (nombreAntiguo=="0") {
                                break;
                            }
                                if (nombreAntiguo.equals(banco.getNombre())) {
                                    System.out.print("Digite nuevo nombre: ");
                                    String nuevoNombre=scanner.next();
                                    banco.setNombre(nuevoNombre);
                                    System.out.println("Nombre cambiado con exito");
                                    break;
                                }else{
                                    System.out.println("Este banco no existe");
                                    break;
                                }

                            }
                        default:
                            break; }
                    break;

                case 2:
                    System.out.print("Digite nombre del banco: ");
                    String nombreBanco=scanner.next();
                    for (Banco banco : bancos) {
                            if (nombreBanco.equals(banco.getNombre())){
                                System.out.print("Digite nombre del cliente: ");
                                String nombreCliente= scanner.next();
                                System.out.print("Digite cedula del cliente: ");
                                int cedulaCliente=scanner.nextInt();
                                banco.adicionarCliente(new Cliente(cedulaCliente,nombreCliente));

                                System.out.print("1. Agregar cuenta cliente \n"+
                                                      "2. salir\n"+
                                                      "Digite opcion: ");

                                int opcion2=scanner.nextInt();

                                if (opcion2==1) {
                                    System.out.print("Digite numero de cuenta: ");
                                    int numeroDecuenta= scanner.nextInt();
                                    System.out.print("Digite tipo de cuenta: ");
                                    String tipoCuenta= scanner.next();
                                    System.out.print("Digite saldo: ");
                                    double saldo= scanner.nextDouble();
                                    Cliente clienteEncontrado=banco.obtenerCliente(cedulaCliente);
                                    clienteEncontrado.CrearCuentaCliente(numeroDecuenta, saldo, tipoCuenta, clienteEncontrado);
                                    System.out.println("Cuenta creada con exito");
                                    
                                } else{
                                    break;
                                }
                            } else{
                                    System.out.println("Este banco no existe");
                                    continue;
                                }
                    }
                    break;
                case 3:
                    System.out.print("Digite nombre del banco a consultar");
                    nombreBanco=scanner.next();    
                    for (Banco banco2 : bancos) {
                     if (nombreBanco.equals(banco2.getNombre())){
                        banco2.verInfoClientes();
                        break;
                    }
                    }

                    break;
                case 4:
                    System.out.print("Digite nombre del banco a consultar: ");
                    nombreBanco=scanner.next();    
                    for (Banco banco2 : bancos) {
                     if (nombreBanco.equals(banco2.getNombre())){
                        double total=banco2.CalcularTotalCuentasAhorro();
                        System.out.println("Totaal de cuentas de ahorro: "+ total);
                        break;
                    }else{
                         System.out.println("Este banco no existe");
                         break;
                                }
                    }
                    break;
                case 5:
                    System.out.print("Digite nombre del banco a consultar: ");
                    nombreBanco=scanner.next();    
                    for (Banco banco2 : bancos) {
                     if (nombreBanco.equals(banco2.getNombre())){
                        double total=banco2.CalcularTotalCuentasCorriente();
                        System.out.println("Total de cuentas de corriente: "+ total);
                        break;
                    }else{
                        System.out.println("Este banco no existe");
                        break;
                                }
                    }
                    break;
            
                default:
                    break;
            }
            
        } while (opcion!=6);
    }
}
