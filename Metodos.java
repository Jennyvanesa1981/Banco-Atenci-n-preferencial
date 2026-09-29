import java.util.Queue;
import java.util.Scanner;

public class Metodos {

    ObjBanco clienteLlamado = null;

    public void LlenarCola(Queue<ObjBanco> colaNormal, Queue<ObjBanco> colaPreferencial,Metodos m, Scanner sc) {

        boolean continuar = true;

        while (continuar) {

            ObjBanco o = new ObjBanco();

            o.setTurno(m.ValidarTurno(colaNormal, colaPreferencial));

            System.out.println("Ingrese la identificacion");
            o.setId(sc.next());

            System.out.println("Ingrese el nombre");
            o.setNombre(sc.next());

            System.out.println("Ingrese el tipo de tramite");
            o.setTipoTramite(sc.next());

            System.out.println("Ingrese la edad");
            o.setEdad(sc.nextInt());

            System.out.println("Ingrese la condicion de atencion");
            System.out.println("1. Normal");
            System.out.println("2. Preferencial");

            int opcion = sc.nextInt();

            if (opcion == 1) {

                o.setCondicionAtencion("Normal");
                colaNormal.offer(o);

            } else {

                o.setCondicionAtencion("Preferencial");
                colaPreferencial.offer(o);
            }

            System.out.println("Desea registrar otro cliente?");
            System.out.println("1. Si");
            System.out.println("2. No");

            int opt = sc.nextInt();

            if (opt == 2) {
                continuar = false;
            }
        }
    }

    public int ValidarTurno(Queue<ObjBanco> colaNormal,Queue<ObjBanco> colaPreferencial) {

        int turno = 0;

        if (colaNormal.isEmpty() && colaPreferencial.isEmpty()) {

            turno = 1;

        } else {

            turno = colaNormal.size() + colaPreferencial.size() + 1;
        }

        return turno;
    }

    public void MostrarCola(Queue<ObjBanco> colaNormal,Queue<ObjBanco> colaPreferencial) {

        System.out.println("----- CLIENTES PREFERENCIALES -----");

        if (colaPreferencial.isEmpty()) {

            System.out.println("No hay clientes preferenciales pendientes.");

        } else {

            for (ObjBanco o : colaPreferencial) {

                System.out.println("Turno: " + o.getTurno());
                System.out.println("Identificacion: " + o.getId());
                System.out.println("Nombre: " + o.getNombre());
                System.out.println("Tipo de tramite: " + o.getTipoTramite());
                System.out.println("Edad: " + o.getEdad());
                System.out.println("Condicion: "+ o.getCondicionAtencion());
                System.out.println("-----------------------------");
            }
        }

        System.out.println("----- CLIENTES NORMALES -----");

        if (colaNormal.isEmpty()) {

            System.out.println("No hay clientes normales pendientes.");

        } else {

            for (ObjBanco o : colaNormal) {

                System.out.println("Turno: " + o.getTurno());
                System.out.println("Identificacion: " + o.getId());
                System.out.println("Nombre: " + o.getNombre());
                System.out.println("Tipo de tramite: " + o.getTipoTramite());
                System.out.println("Edad: " + o.getEdad());
                System.out.println("Condicion: " + o.getCondicionAtencion());
                System.out.println("-----------------------------");
            }
        }
    }

    public void AtenderCliente(Queue<ObjBanco> colaNormal,Queue<ObjBanco> colaPreferencial) {

        if (clienteLlamado != null) {

            System.out.println("Primero debe marcar como atendido al cliente llamado.");

        } else if (!colaPreferencial.isEmpty()) {

            clienteLlamado = colaPreferencial.poll();

            System.out.println("Cliente llamado: "+ clienteLlamado.getNombre());

            System.out.println("Turno: "+ clienteLlamado.getTurno());

            System.out.println("Condicion: " + clienteLlamado.getCondicionAtencion());

        } else if (!colaNormal.isEmpty()) {

            clienteLlamado = colaNormal.poll();

            System.out.println("Cliente llamado: "+ clienteLlamado.getNombre());

            System.out.println("Turno: " + clienteLlamado.getTurno());

            System.out.println("Condicion: " + clienteLlamado.getCondicionAtencion());

        } else {

            System.out.println("No hay clientes en la cola.");
        }
    }

    public void MarcarAtendido(Queue<ObjBanco> colaAtendidos) {

        if (clienteLlamado != null) {

            colaAtendidos.offer(clienteLlamado);

            System.out.println("Cliente marcado como atendido.");
            System.out.println("Nombre: " + clienteLlamado.getNombre());
            System.out.println("Turno: " + clienteLlamado.getTurno());

            clienteLlamado = null;

        } else {

            System.out.println("No hay ningun cliente llamado.");
        }
    }

    public void CambiarPreferencial(Queue<ObjBanco> colaNormal,Queue<ObjBanco> colaPreferencial, Scanner sc) {

        System.out.println("Ingrese la identificacion del cliente:");
        String id = sc.next();

        ObjBanco cliente = null;

        for (ObjBanco o : colaNormal) {

            if (o.getId().equals(id)) {

                cliente = o;
                break;
            }
        }

        if (cliente != null) {

            colaNormal.remove(cliente);

            cliente.setCondicionAtencion("Preferencial");

            colaPreferencial.offer(cliente);

            System.out.println("El cliente cambio a atencion preferencial.");

        } else {

            System.out.println("No se encontro el cliente en la cola normal.");
        }
    }

    public void CancelarTurno(Queue<ObjBanco> colaNormal, Queue<ObjBanco> colaPreferencial, Queue<ObjBanco> colaAtendidos,Scanner sc) {

        System.out.println("Ingrese la identificacion del cliente:");
        String id = sc.next();

        ObjBanco cliente = null;

        for (ObjBanco o : colaNormal) {

            if (o.getId().equals(id)) {

                cliente = o;
                break;
            }
        }

        if (cliente != null) {

            colaNormal.remove(cliente);

            System.out.println("El turno fue cancelado.");

            return;
        }

        for (ObjBanco o : colaPreferencial) {

            if (o.getId().equals(id)) {

                cliente = o;
                break;
            }
        }

        if (cliente != null) {

            colaPreferencial.remove(cliente);

            System.out.println("El turno fue cancelado.");

            return;
        }

        for (ObjBanco o : colaAtendidos) {

            if (o.getId().equals(id)) {

                System.out.println("El cliente ya fue atendido.");

                return;
            }
        }

        System.out.println("No se encontro el cliente.");
    }

    public void BuscarCliente(Queue<ObjBanco> colaNormal, Queue<ObjBanco> colaPreferencial, Queue<ObjBanco> colaAtendidos,Scanner sc) {

        System.out.println("Ingrese la identificacion del cliente:");
        String id = sc.next();

        for (ObjBanco o : colaPreferencial) {

            if (o.getId().equals(id)) {

                System.out.println("Cliente encontrado.");
                System.out.println("Nombre: " + o.getNombre());
                System.out.println("Turno: " + o.getTurno());
                System.out.println("Condicion: "
                        + o.getCondicionAtencion());

                return;
            }
        }

        for (ObjBanco o : colaNormal) {

            if (o.getId().equals(id)) {

                System.out.println("Cliente encontrado.");
                System.out.println("Nombre: " + o.getNombre());
                System.out.println("Turno: " + o.getTurno());
                System.out.println("Condicion: "
                        + o.getCondicionAtencion());

                return;
            }
        }

        for (ObjBanco o : colaAtendidos) {

            if (o.getId().equals(id)) {

                System.out.println("Cliente encontrado.");
                System.out.println("Nombre: " + o.getNombre());
                System.out.println("Turno: " + o.getTurno());
                System.out.println("Condicion: "
                        + o.getCondicionAtencion());
                System.out.println("Estado: Atendido");

                return;
            }
        }

        System.out.println("No se encontro el cliente.");
    }

    public void CantidadEsperando(Queue<ObjBanco> colaNormal,Queue<ObjBanco> colaPreferencial) {

        int cantidad = colaNormal.size() + colaPreferencial.size();

        System.out.println("Personas esperando: " + cantidad);
    }

    public void CantidadPorCondicion(Queue<ObjBanco> colaNormal, Queue<ObjBanco> colaPreferencial) {

        System.out.println("Clientes normales pendientes: " + colaNormal.size());

        System.out.println("Clientes preferenciales pendientes: " + colaPreferencial.size());
    }
}
