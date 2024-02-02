import java.util.ArrayList;

public class Banco {
    private String nombre;
    private ArrayList<Cliente> clientes;
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public Banco(String nombre) {
        this.nombre = nombre;
        this.clientes =new ArrayList<Cliente>();
    }
    public String adicionarCliente(Cliente cliente){
        clientes.add(cliente);
         return "Cliente asignado con exito";}
    
    public int obtenerNumeroDeClientes(){
        int cantidad= clientes.size();
        return cantidad; }

    public void verInfoClientes(){
        for (Cliente cliente : clientes) {
            System.out.println("Nombre: "+cliente.getNombre()+ " Cedula: "+ cliente.getCedula() +" Cuenta= " + cliente.getCuenta());
        
        }
    }

    public double CalcularTotalCuentasAhorro(){
        String ahorro= "Ahorro";
        double total=0;
        for (Cliente cliente : clientes) {
         if (ahorro.equals(cliente.getCuenta().getTipo())){
                total+= cliente.getCuenta().getSaldo();}}
        return total;
    }

    public double CalcularTotalCuentasCorriente(){
        String ahorro= "Corriente";
        double total=0;
        for (Cliente cliente : clientes) {
         if (ahorro.equals(cliente.getCuenta().getTipo())){
                total+= cliente.getCuenta().getSaldo();}}
        return total;
    }

    public void verInformacionClientes(){
        for (Cliente cliente : clientes) {
            System.out.println("Nombre: "+ cliente.getNombre()+"\n"+
                                "Cedula: "+ cliente.getCedula()+ "\n"+
                                "Tipo de Cuenta: "+ cliente.getCuenta().getTipo()+"\n"+
                                "Numero de  cuenta: "+ cliente.getCuenta().getNumero()+ "\n"+
                                "Saldo: "+cliente.getCuenta().getSaldo());

        }
    }

    public Cliente obtenerCliente(int cedula){
        Cliente correcto=null;
        for (Cliente cliente : clientes) {
            if (cedula== cliente.getCedula()){
                 correcto=cliente;
                 break;
            }else{
                correcto=null;
            }}

        if (correcto==null) {
             System.out.println("Cliente no existe");
             return correcto;
        } else {
                return correcto;
            }

       
    }
    
}
