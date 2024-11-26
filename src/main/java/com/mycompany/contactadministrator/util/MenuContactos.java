package com.mycompany.contactadministrator.util;

import java.util.*;


import com.mycompany.contactadministrator.model.*;

import java.util.Scanner;

public class MenuContactos {
    private static final int OPCION_SALIR = 6;

    public static void mostrarMenuContactos(OurCircularDoubleList<Contacto> contactos) {
        if (contactos.estaVacia()) {
            System.out.println("No hay contactos disponibles: ");
            mostrarOpcionesSinContactos(contactos);
            return;
        }

        OurCircularDoubleList<Contacto>.OurCircularDoubleListIterator iterator = contactos.iterator();
        int opcion = -1;
        boolean hasContact = true;

        do {
            if (hasContact) {
                Contacto contactoActual = iterator.peek();
                if (contactoActual != null) {
                    System.out.println(contactoActual); // Muestra el contacto actual
                } else {
                    hasContact = false; // No hay más contactos
                }
            } else {
                System.out.println("No hay más contactos.");
                if (mostrarOpcionesSinContactos(contactos) == 2) {
                    opcion = OPCION_SALIR;
                }
            }

            if (opcion != OPCION_SALIR) {
                mostrarOpcionesContactos();
                opcion = Inputs.pedirInputNumerico();
                hasContact = manejarOpcionesContactos(contactos, iterator, opcion);

                // Verifica si la lista está vacía después de manejar la opción
                if (contactos.estaVacia()) {
                    System.out.println("No hay contactos disponibles.");
                    mostrarOpcionesSinContactos(contactos);
                    return; // Salir del método si no hay contactos
                }
            }
        } while (opcion != OPCION_SALIR);
    }

    private static boolean manejarOpcionesContactos(OurCircularDoubleList<Contacto> contactos,
                                                    OurCircularDoubleList<Contacto>.OurCircularDoubleListIterator iterator, int opcion) {
        if (contactos.estaVacia()) {
            mostrarOpcionesSinContactos(contactos);
            return false;
        }

        switch (opcion) {
            case 1: // Siguiente contacto
                if (iterator.hasNext()) {
                    iterator.next();
                } else {
                    System.out.println("No hay más contactos.");
                    return false;
                }
                break;
            case 2: // Contacto anterior
                    iterator.previous();
                break;
            case 3:
                editarContacto(iterator.peek());
                break;
            case 4:
                eliminarContacto(iterator);
                break;
            case 5: // Añadir contacto
                System.out.println("Añadiendo contacto: ");
                MenuContacto.añadirContacto(contactos);
                break;
            case OPCION_SALIR: // Regresar al menú principal
                System.out.println("Regresando al menú principal");
                return false;
            default:
                System.out.println("Elige una opción correcta.");
        }
        return true;
    }

    private static void eliminarContacto(OurCircularDoubleList<Contacto>.OurCircularDoubleListIterator iterator) {
        if (iterator.hasNext()) {
            System.out.println("Eliminando contacto: ");
            iterator.remove();
            if (!iterator.hasNext()) {
                System.out.println("No hay más contactos después de la eliminación.");
            }
        } else {
            System.out.println("No hay contacto para eliminar.");
        }
    }

    private static void editarContacto(Contacto contacto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Editando contacto: ");
        System.out.println(contacto);

        if (contacto instanceof ContactoPersona) {
            editarContactoPersona((ContactoPersona) contacto, scanner);
        } else if (contacto instanceof ContactoEmpresa) {
            editarContactoEmpresa((ContactoEmpresa) contacto, scanner);
        } else {
            System.out.println("Tipo de contacto no reconocido.");
        }

        System.out.println("Contacto actualizado: ");
        System.out.println(contacto);
    }

    private static void editarContactoPersona(ContactoPersona contacto, Scanner scanner) {
        mostrarOpcionesEdicionPersona();
        int opcion = Inputs.pedirInputNumerico();
        switch (opcion) {
            case 1: contacto.setNombre(pedirNuevoValor(scanner, "Nuevo nombre: ")); break;
            case 2: contacto.setApellido(pedirNuevoValor(scanner, "Nuevo apellido: ")); break;
            case 3: editarDireccion(contacto, scanner); break;
            case 4: editarTelefono(contacto, scanner); break;
            case 5: editarEmail(contacto, scanner); break;
            case 6: contacto.setFechaNacimiento(pedirNuevoValor(scanner, "Nueva fecha de nacimiento (formato: dd/mm/yyyy): ")); break;
            case 7: editarRedSocial(contacto, scanner); break;
            case 8: editarFoto(contacto, scanner); break;
            case 9: contacto.setTipoRelacion(pedirNuevoValor(scanner, "Nuevo tipo de relación: ")); break;
            case 10: System.out.println("Cancelando edición."); break;
            default: System.out.println("Opción no válida.");
        }
    }

    private static void editarContactoEmpresa(ContactoEmpresa contacto, Scanner scanner) {
        mostrarOpcionesEdicionEmpresa();
        int opcion = Inputs.pedirInputNumerico();
        switch (opcion) {
            case 1: contacto.setNombre(pedirNuevoValor(scanner, "Nuevo nombre: ")); break;
            case 2: contacto.setApellido(pedirNuevoValor(scanner, "Nuevo apellido: ")); break;
            case 3: editarDireccion(contacto, scanner); break;
            case 4: editarTelefono(contacto, scanner); break;
            case 5: editarEmail(contacto, scanner); break;
            case 6: contacto.setNombreEmpresa(pedirNuevoValor(scanner, "Nuevo nombre de empresa: ")); break;
            case 7: contacto.setCargo(pedirNuevoValor(scanner, "Nuevo cargo: ")); break;
            case 8: contacto.setPaisResidencia(pedirNuevoValor(scanner, "Nuevo país de residencia: ")); break;
            case 9: editarRedSocial(contacto, scanner); break;
            case 10: editarFoto(contacto, scanner); break;
            case 11: System.out.println("Cancelando edición."); break;
            default: System.out.println("Opción no válida.");
        }
    }

    private static void editarDireccion(Contacto contacto, Scanner scanner) {
        System.out.print("Nueva dirección: ");
        String nuevaDireccion = scanner.nextLine();
        System.out.println("Ingresa el link de la nueva dirección");
        String linkNuevaDireccion = scanner.nextLine();
        Direccion nuevaDireccionFinal = new Direccion(nuevaDireccion, linkNuevaDireccion);
        contacto.setDireccion(nuevaDireccionFinal);
    }

    private static void editarTelefono(Contacto contacto, Scanner scanner) {
        System.out.print("¿Agregar o eliminar teléfono? [1] Agregar [2] Eliminar: ");
        int telefonoOpcion = Inputs.pedirInputNumerico();
        if (telefonoOpcion == 1) {
            System.out.print("Número de teléfono a agregar: ");
            String telefono = scanner.nextLine();
            contacto.agregarTelefono(telefono);
        } else if (telefonoOpcion == 2) {
            System.out.print("Número de teléfono a eliminar: ");
            String telefono = scanner.nextLine();
            contacto.getTelefonos().eliminar(telefono);
        }
    }

    private static void editarEmail(Contacto contacto, Scanner scanner) {
        System.out.print("¿Agregar o eliminar email? [1] Agregar [2] Eliminar: ");
        int emailOpcion = Inputs.pedirInputNumerico();
        if (emailOpcion == 1) {
            System.out.print("Email a agregar (formato: direccion tipo): ");
            String[] emailInput = scanner.nextLine().split(" ");
            if (emailInput.length == 2) {
                String direccionEmail = emailInput[0];
                String tipoEmail = emailInput[1];
                contacto.agregarEmail(new Email(direccionEmail, tipoEmail));
            } else {
                System.out.println("Formato incorrecto. Asegúrate de ingresar ambos valores.");
            }
        } else if (emailOpcion == 2) {
            System.out.print("Email a eliminar (formato: direccion tipo): ");
            String[] emailInput = scanner.nextLine().split(" ");
            if (emailInput.length == 2) {
                String direccionEmail = emailInput[0];
                String tipoEmail = emailInput[1];
                contacto.getEmails().eliminar(new Email(direccionEmail, tipoEmail));
            } else {
                System.out.println("Formato incorrecto. Asegúrate de ingresar ambos valores.");
            }
        }
    }

    private static void editarRedSocial(Contacto contacto, Scanner scanner) {
        System.out.print("¿Agregar o eliminar red social? [1] Agregar [2] Eliminar: ");
        int redSocialOpcion = Inputs.pedirInputNumerico();
        if (redSocialOpcion == 1) {
            System.out.print("Usuario de Red social a agregar: ");
            String user = scanner.nextLine();
            System.out.println("Red Social");
            String redSocial = scanner.nextLine();
            RedSocial redSocialNueva = new RedSocial(redSocial, user);
            contacto.agregarRedSocial(redSocialNueva);
        } else if (redSocialOpcion == 2) {
            System.out.print("Red social a eliminar: ");
            String user = scanner.nextLine();
            System.out.println("Red Social");
            String redSocial = scanner.nextLine();
            RedSocial redSocialEliminar = new RedSocial(redSocial, user);
            contacto.getRedesSociales().eliminar(redSocialEliminar);
        }
    }

    private static void editarFoto(Contacto contacto, Scanner scanner) {
        System.out.print("¿Agregar o eliminar foto? [1] Agregar [2] Eliminar: ");
        int fotoOpcion = Inputs.pedirInputNumerico();
        if (fotoOpcion == 1) {
            System.out.print("Ruta de la foto a agregar: ");
            String rutaFoto = scanner.nextLine();
            Foto foto = new Foto(rutaFoto);
            contacto.agregarFoto(foto);
        } else if (fotoOpcion == 2) {
            System.out.print("Ruta de la foto a eliminar: ");
            String rutaFoto = scanner.nextLine();
            Foto foto = new Foto(rutaFoto);
            contacto.getFotos().eliminar(foto);
        }
    }

    private static String pedirNuevoValor(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private static void mostrarOpcionesEdicionPersona() {
        System.out.println("¿Qué deseas editar?");
        System.out.println("[1] Nombre");
        System.out.println("[2] Apellido");
        System.out.println("[3] Dirección");
        System.out.println("[4] Teléfonos");
        System.out.println("[5] Emails");
        System.out.println("[6] Fecha de nacimiento");
        System.out.println("[7] Redes sociales");
        System.out.println("[8] Fotos");
        System.out.println("[9] Tipo de relación");
        System.out.println("[10] Cancelar");
    }

    private static void mostrarOpcionesEdicionEmpresa() {
        System.out.println("¿Qué deseas editar?");
        System.out.println("[1] Nombre");
        System.out.println("[2] Apellido");
        System.out.println("[3] Dirección");
        System.out.println("[4] Teléfonos");
        System.out.println("[5] Emails");
        System.out.println("[6] Nombre de empresa");
        System.out.println("[7] Cargo");
        System.out.println("[8] País de residencia");
        System.out.println("[9] Redes sociales");
        System.out.println("[10] Fotos");
        System.out.println("[11] Cancelar");
    }

    public static int mostrarOpcionesSinContactos(OurCircularDoubleList<Contacto> contactos) {
        System.out.println("Opciones: ");
        System.out.println("[1] Añadir Contacto");
        System.out.println("[2] Regresar al menú principal");
        int opcion = Inputs.pedirInputNumerico();
        if (opcion == 1) {
            MenuContacto.añadirContacto(contactos);
        }
        return opcion;
    }

    public static void mostrarOpcionesContactos() {
        System.out.println("Opciones para manejar contactos: ");
        System.out.println("[1] Siguiente >>");
        System.out.println("[2] << Anterior");
        System.out.println("[3] Editar contacto");
        System.out.println("[4] Borrar contacto.");
        System.out.println("[5] Añadir contacto.");
        System.out.println("[6] Regresar al menú principal.");
        System.out.println("");
    }

    public static void buscarContactos(OurCircularDoubleList<Contacto> contactos) {
        if (contactos.estaVacia()) {
            System.out.println("No hay contactos disponibles para buscar.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre o apellido del contacto a buscar: ");
        String terminoBusqueda = scanner.nextLine().toLowerCase();

        boolean encontrado = false;
        OurCircularDoubleList<Contacto>.OurCircularDoubleListIterator iterator = contactos.iterator();

        // Guardar el primer contacto para evitar el bucle infinito
        if (!iterator.hasNext()) {
            System.out.println("No hay contactos disponibles para buscar.");
            return;
        }

        Contacto primerContacto = iterator.next();
        Contacto inicioContacto = primerContacto; // Guardar el contacto inicial

        do {
            // Comprobar el contacto actual
            if (primerContacto.getNombre().toLowerCase().contains(terminoBusqueda) ||
                    primerContacto.getApellido().toLowerCase().contains(terminoBusqueda)) {
                System.out.println("Contacto encontrado: " + primerContacto);
                encontrado = true;
            }

            // Avanzar al siguiente contacto
            if (iterator.hasNext()) {
                primerContacto = iterator.next();
            } else {
                break; // Salir si no hay más contactos
            }

        } while (primerContacto != inicioContacto); // Comprobar si hemos vuelto al inicio

        if (!encontrado) {
            System.out.println("No se encontraron contactos que coincidan con la búsqueda.");
        }
    }


    public static void filtrarContactos(OurCircularDoubleList<Contacto> contactos) {
    if (contactos.estaVacia()) {
        System.out.println("No hay contactos para filtrar.");
        return;
    }

    Scanner scanner = new Scanner(System.in);
    System.out.println("Seleccione el criterio de búsqueda:");
    System.out.println("1. Término de búsqueda (nombre, apellido, o empresa)");
    System.out.println("2. País de residencia");
    System.out.println("3. Mes de cumpleaños");
    int opcion = scanner.nextInt();
    scanner.nextLine(); // Consumir el salto de línea

    switch (opcion) {
        case 1:
            System.out.print("Ingrese el término de búsqueda: ");
            String terminoBusqueda = scanner.nextLine().toLowerCase();
            filtrarPorTermino(contactos, terminoBusqueda);
            break;

        case 2:
            System.out.print("Ingrese el país de residencia: ");
            String pais = scanner.nextLine().toLowerCase();
            filtrarPorPais(contactos, pais);
            break;

        case 3:
            System.out.print("Ingrese el número del mes (1-12): ");
            int mes = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            filtrarPorMes(contactos, mes);
            break;

        default:
            System.out.println("Opción no válida.");
    }
}

   
    public static void filtrarPorTermino(OurCircularDoubleList<Contacto> contactos, String termino) {
        System.out.println("Contactos que coinciden con '" + termino + "':");
        Iterator<Contacto> iterator = contactos.iterator();
        while (iterator.hasNext()) {
            Contacto contacto = iterator.next();
            if (contacto.getNombre().toLowerCase().contains(termino) ||
                contacto.getApellido().toLowerCase().contains(termino)) {
                System.out.println(contacto);
            }

          
            if (contacto instanceof ContactoEmpresa) {
                ContactoEmpresa empresa = (ContactoEmpresa) contacto;
                if (empresa.getNombreEmpresa() .toLowerCase().contains(termino)) {
                    System.out.println(contacto);
                }
            }
        }
    }

    
    public static void filtrarPorPais(OurCircularDoubleList<Contacto> contactos, String pais) {
        System.out.println("Contactos que viven en " + pais + ":");
        Iterator<Contacto> iterator = contactos.iterator();
        while (iterator.hasNext()) {
            Contacto contacto = iterator.next();
            if (contacto instanceof ContactoEmpresa) {
                ContactoEmpresa empresa = (ContactoEmpresa) contacto;
                if (empresa.getPaisResidencia().toLowerCase().contains(pais)) {
                    System.out.println(contacto);
                }
            }
        }
    }
    public static void filtrarPorMes(OurCircularDoubleList<Contacto> contactos, int mes) {
        System.out.println("Contactos con cumpleaños en el mes " + mes + ":");
        Iterator<Contacto> iterator = contactos.iterator();
        while (iterator.hasNext()) {
            Contacto contacto = iterator.next();
            if (contacto instanceof ContactoPersona) {
                ContactoPersona contactoPersona = (ContactoPersona) contacto;
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(contactoPersona.getFechaNacimiento());
                int mesCumpleanos = calendar.get(Calendar.MONTH) + 1; 
                if (mesCumpleanos == mes) {
                    System.out.println(contacto);
                }
            }
        }
    }


}