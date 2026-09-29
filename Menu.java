import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
    

        Queue<ObjBanco> colaNormal = new LinkedList<>();
        Queue<ObjBanco> colaPreferencial = new LinkedList<>();
        Queue<ObjBanco> colaAtendidos = new LinkedList<>();

        Metodos m = new Metodos();

        int opcion = 0;
        boolean continuar = true;


        while (continuar) {
            System.out.println("========== BANCO ==========");
            
            System.out.println("1) Registrar clientes");
            System.out.println("2) Consulta de clientes");
            System.out.println("3) Llamar al siguiente cliente");
            System.out.println("4) Marcar Cliente Atendido");
            System.out.println("5) Cambiar cliente de normal a preferencial");
            System.out.println("6) Cancelar turno de un cliente");
            System.out.println("7) Buscar cliente por identificacion");
            System.out.println("8) Consulta de cantidad de clientes esperando");
            System.out.println("9) Mostrar clientes normales o preferenciales");
            System.out.println("10) Salir");
            System.out.println("============================");
            System.out.println("Ingrese una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    m.LlenarCola(colaNormal, colaPreferencial, m, sc);
                    break;
                case 2:
                    m.MostrarCola(colaNormal, colaPreferencial);
                    break;
                case 3:
                    m.AtenderCliente(colaNormal, colaPreferencial);
                    break;
                case 4:
                    m.MarcarAtendido(colaAtendidos);
                    break;
                case 5:
                    m.CambiarPreferencial(colaNormal, colaPreferencial, sc);
                    break;
                case 6:
                    m.CancelarTurno(colaNormal, colaPreferencial, colaAtendidos, sc);
                    break;
                case 7:
                    m.BuscarCliente(colaNormal, colaPreferencial, colaAtendidos, sc);
                    break;
                case 8:
                    m.CantidadEsperando(colaNormal, colaPreferencial);
                    break;
                case 9:
                    m.CantidadPorCondicion(colaNormal, colaPreferencial);
                    break;
                case 10:
                    continuar = false;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
            }
        }

        sc.close();
    }
}
    


