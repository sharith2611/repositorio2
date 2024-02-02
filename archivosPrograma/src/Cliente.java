

public class Cliente {
    int cedula;
    String nombre;
    Cuenta cuenta;
  
    public Cliente(int cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.cuenta = null;
    }

    public int getCedula() {
        return cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public Cuenta getCuenta() {
        return cuenta;
    } 

    public void CrearCuentaCliente(int numero, double saldo, String tipo,Cliente propietario){
       this.cuenta= new Cuenta(numero, tipo, saldo,propietario);
    }
    


}
