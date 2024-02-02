
public class Cuenta {
    int numero;
    String tipo;
    double saldo;
    Cliente propietario;
    
    public Cuenta(int numero, String tipo, double saldo, Cliente propietario) {
        this.numero = numero;
        this.tipo = tipo;
        this.saldo = saldo;
        this.propietario=propietario;
    }

    public String getTipo() {
        return tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "[numero=" + numero + ", tipo=" + tipo + ", saldo=" + saldo + "]";
    }
    
    
    
}
