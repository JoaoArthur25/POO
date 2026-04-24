package dados;

public class Reserva {
    private int numReserva;
    private String dataVoo;
    private String horaVoo;
    private float preco;
    private String classeVoo;
    private boolean idaEVolta;
    private int poltrona;
    private Cidade origem;
    private Cidade destino;

    public Reserva(int numReserva, String dataVoo, String horaVoo, float preco,
                   String classeVoo, boolean idaEVolta, int poltrona,
                   Cidade origem, Cidade destino) {
        this.numReserva = numReserva;
        this.dataVoo = dataVoo;
        this.horaVoo = horaVoo;
        this.preco = preco;
        this.classeVoo = classeVoo;
        this.idaEVolta = idaEVolta;
        this.poltrona = poltrona;
        this.origem = origem;
        this.destino = destino;
    }

    public int getNumReserva() {
        return numReserva;
    }

    public String getDataVoo() {
        return dataVoo;
    }

    public String getHoraVoo() {
        return horaVoo;
    }

    public float getPreco() {
        return preco;
    }

    public String getClasseVoo() {
        return classeVoo;
    }

    public boolean isIdaEVolta() {
        return idaEVolta;
    }

    public int getPoltrona() {
        return poltrona;
    }

    public Cidade getOrigem() {
        return origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "numReserva=" + numReserva +
                ", dataVoo='" + dataVoo + '\'' +
                ", horaVoo='" + horaVoo + '\'' +
                ", preco=" + preco +
                ", classeVoo='" + classeVoo + '\'' +
                ", idaEVolta=" + idaEVolta +
                ", poltrona=" + poltrona +
                ", origem=" + origem +
                ", destino=" + destino +
                '}';
    }
}
