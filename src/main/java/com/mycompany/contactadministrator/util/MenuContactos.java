package com.mycompany.contactadministrator.util;

import com.mycompany.contactadministrator.model.*;

import java.time.LocalDate;
import java.util.Scanner;

import static com.mycompany.contactadministrator.util.MenuContacto.buscarYAgregarContactoAsociado;

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
                iterator.next();
                break;
            case 2: // Contacto anterior
                iterator.previous();
                break;
            case 3:
                editarContacto(contactos,iterator.peek());
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

    private static void editarContacto(OurCircularDoubleList<Contacto> contactos,Contacto contacto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Editando contacto: ");
        System.out.println(contacto);

        if (contacto instanceof ContactoPersona) {
            editarContactoPersona(contactos,(ContactoPersona) contacto, scanner);
        } else if (contacto instanceof ContactoEmpresa) {
            editarContactoEmpresa(contactos,(ContactoEmpresa) contacto, scanner);
        } else {
            System.out.println("Tipo de contacto no reconocido.");
        }

        System.out.println("Contacto actualizado: ");
        System.out.println(contacto);
    }

    private static void editarContactoPersona(OurCircularDoubleList<Contacto> contactos,ContactoPersona contacto, Scanner scanner) {
        mostrarOpcionesEdicionPersona();
        int opcion = Inputs.pedirInputNumerico();
        switch (opcion) {
            case 1: contacto.setNombre(pedirNuevoValor(scanner, "Nuevo nombre: ")); break;
            case 2: contacto.setApellido(pedirNuevoValor(scanner, "Nuevo apellido: ")); break;
            case 3: editarDireccion(contacto, scanner); break;
            case 4: editarTelefono(contacto, scanner); break;
            case 5: editarEmail(contacto, scanner); break;
            case 6: editarFechaNacimiento(contacto, scanner);break;
            case 7: editarRedSocial(contacto, scanner); break;
            case 8: editarFoto(contacto, scanner); break;
            case 9: contacto.setTipoRelacion(pedirNuevoValor(scanner, "Nuevo tipo de relación: ")); break;
            case 10: editarContactosAsociados(contactos, contacto, scanner);break;
            case 11: System.out.println("Cancelando edición."); break;
            default: System.out.println("Opción no válida.");
        }
    }

    private static void editarFechaNacimiento(ContactoPersona contacto, Scanner scanner){
        System.out.println("Nueva fecha de nacimiento (formato: dd/MM/yyyy): ");
        String nuevaFechaStr = scanner.nextLine();
        LocalDate nuevaFecha = ContactoPersona.convertirStringADate(nuevaFechaStr);
        if (nuevaFecha != null) {
            contacto.setFechaNacimiento(nuevaFecha);
        } else {
            System.out.println("Fecha de nacimiento no válida. No se ha actualizado.");
            editarFechaNacimiento(contacto,scanner);
        }
    }

    private static void editarContactoEmpresa(OurCircularDoubleList<Contacto> contactos,ContactoEmpresa contacto, Scanner scanner) {
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
            case 8: editarRedSocial(contacto, scanner); break;
            case 9: editarFoto(contacto, scanner); break;
            case 10: editarContactosAsociados(contactos,contacto, scanner); break;
            case 11: System.out.println("Cancelando edición."); break;
            default: System.out.println("Opción no válida.");
        }
    }

    private static void editarDireccion(Contacto contacto, Scanner scanner) {
        System.out.println("Nuevo pais: ");
        String nuevoPais = scanner.nextLine();
        System.out.print("Nueva dirección: ");
        String nuevaDireccion = scanner.nextLine();
        System.out.println("Ingresa el link de la nueva dirección");
        String linkNuevaDireccion = scanner.nextLine();
        Direccion nuevaDireccionFinal = new Direccion(nuevoPais, nuevaDireccion, linkNuevaDireccion);
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

    private static void editarContactosAsociados(OurCircularDoubleList<Contacto> contactos,Contacto contacto,
                                                 Scanner scanner) {
        OurCircularDoubleList<Contacto> contactosAsociados = contacto.getContactosAsociados();
        OurCircularDoubleList<Contacto>.OurCircularDoubleListIterator iterator = contactosAsociados.iterator();

        if (contactosAsociados.estaVacia()) {
            System.out.println("No hay contactos asociados.");
            mostrarOpcionesSinContactosAsociados(contactos, contacto, scanner);
        } else {
            System.out.println("Editando contactos asociados:");
            int opcion;
            do {
                if (iterator.hasNext()) {
                    Contacto contactoActual = iterator.peek();
                    System.out.println("Contacto actual: ");
                    System.out.println(contactoActual+"\n");
                }

                System.out.println("[1] Siguiente");
                System.out.println("[2] Anterior");
                System.out.println("[3] Eliminar contacto actual");
                System.out.println("[4] Añadir nuevo contacto asociado");
                System.out.println("[5] Salir");
                opcion = Inputs.pedirInputNumerico();

                switch (opcion) {
                    case 1: // Siguiente
                        iterator.next();
                        break;
                    case 2: // Anterior
                        iterator.previous();
                        break;
                    case 3: // Eliminar contacto actual
                        iterator.remove();
                        System.out.println("Contacto eliminado.");
                        break;
                    case 4: // Añadir nuevo contacto asociado
                        System.out.println("Lista de contactos disponibles:");

                        System.out.print("Ingrese el nombre o apellido del nuevo contacto asociado: ");
                        String terminoBusqueda = scanner.nextLine();
                        buscarYAgregarContactoAsociado(contactos, contacto, terminoBusqueda);
                        break;
                    case 5: // Salir
                        System.out.println("Saliendo de edición de contactos asociados.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 5 && !contactosAsociados.estaVacia());

            if(contactosAsociados.estaVacia()){
                mostrarOpcionesSinContactosAsociados(contactos, contacto, scanner);
            }
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
        System.out.println("[10] Contactos Relacionados");
        System.out.println("[11] Cancelar");
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
        System.out.println("[8] Redes sociales");
        System.out.println("[9] Fotos");
        System.out.println("[10] Contactos Relacionados");
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

    public static int mostrarOpcionesSinContactosAsociados(OurCircularDoubleList<Contacto> contactos,Contacto contacto,
                                                           Scanner scanner) {
        System.out.println("No hay contactos asociados para este contacto");
        System.out.println("Opciones: ");
        System.out.println("[1] Añadir Contacto");
        System.out.println("[2] Regresar al menú contacto");
        int opcion = Inputs.pedirInputNumerico();
        if (opcion == 1) {
            String terminoBusqueda = scanner.nextLine();
            MenuContacto.buscarYAgregarContactoAsociado(contactos, contacto, terminoBusqueda);
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
}