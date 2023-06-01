class Boxeador {
    private String nombre;
    private double peso;
    private double estatura;
    private String categoria;
    private double imc;

    public Boxeador(String nombre, double peso, double estatura) {
        this.nombre = nombre;
        this.peso = peso;
        this.estatura = estatura;
        calcularIMC();
        calcularCategoria();
    }

    public Boxeador() {
        this.nombre = "";
        this.peso = 0.0;
        this.estatura = 0.0;
        calcularIMC();
        calcularCategoria();
    }

    private void calcularIMC() {
        this.imc = peso / (estatura * estatura);
    }

    private void calcularCategoria() {
        if (peso > 94) {
            this.categoria = "Pesado";
        } else if (peso >= 79 && peso <= 94) {
            this.categoria = "Crucero";
        } else {
            this.categoria = "Semipesado";
        }
    }

    public boolean puedeGanarle(Boxeador otroBoxeador) {
        return this.imc > otroBoxeador.imc;
    }

    public void setPeso(double peso) {
        this.peso = peso;
        calcularIMC();
        calcularCategoria();
    }

    public String getCategoria() {
        return categoria;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n"
                + "Peso: " + peso + " kg\n"
                + "Estatura: " + estatura + " m\n"
                + "Categoría: " + categoria + "\n"
                + "IMC: " + imc;
    }
}