class Empleado {
    private String nombre;
    private String DNI;
    private int numero;
    private Portfolio portfolio;

    public Empleado(String nombre, String DNI, int numero) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.numero = numero;
        this.portfolio = new Portfolio();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public int getNumero() {
        return numero;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public static Empleado max(ArrayList<Empleado> empleados) {
        if (empleados.isEmpty()) {
            return null;
        }
        Empleado maxEmpleado = empleados.get(0);
        for (Empleado emp : empleados) {
            if (emp.getPortfolio().media() > maxEmpleado.getPortfolio().media()) {
                maxEmpleado = emp;
            }
        }
        return maxEmpleado;
    }
}