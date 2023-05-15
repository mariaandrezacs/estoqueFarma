package estoqueFarma;

public class Remedio {
    int id; 
    String laboratorio;
    String nome;
    double preco;

    public Remedio(int id, String laboratorio, String nome, double preco) {
        this.id = id;
        this.laboratorio = laboratorio;
        this.nome = nome;
        this.preco = preco;
    }

    public Remedio(String laboratorio, String nome, double preco) {
        this.laboratorio = laboratorio;
        this.nome = nome;
        this.preco = preco;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
}
