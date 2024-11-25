package com.mycompany.contactadministrator.util;

import com.mycompany.contactadministrator.model.*;

import java.util.Scanner;

public class MenuContactos {

    public static void mostrarMenuContactos(OurCircularDoubleList<Contacto> contactos) {
        if (contactos.estaVacia()) {
            System.out.println("No hay contactos disponibles: ");
            mostrarOpcionesSinContactos(contactos);
            return;
        }

        OurCircularDoubleList<Contacto>.OurCircularDoubleListIterator iterator = contactos.iterator();
        int opcion = 0;
        boolean hasContact = true;

        do {
            if (hasContact) {
                System.out.println(iterator.peek()); // Muestra el contacto actual
            } else {
                System.out.println("No hay más contactos.");
                //evita que se muestre el menu de contactos si no hay mas contactos disponibles
                if(mostrarOpcionesSinContactos(contactos) == 2)
                    opcion = 6;
            }
            if(opcion != 6) {
                mostrarOpcionesContactos();
                opcion = Inputs.pedirInputNumerico();
                hasContact = manejarOpcionesContactos(contactos, iterator, opcion);
            }
        } while (opcion != 6);
    }

    private static boolean manejarOpcionesContactos(OurCircularDoubleList<Contacto> contactos,
                                                    OurCircularDoubleList<Contacto>.OurCircularDoubleListIterator iterator, int opcion) {
        if (contactos.estaVacia()) {
            mostrarOpcionesSinContactos(contactos);
            return false; // Indica que no hay contactos
        }

        switch (opcion) {
            case 1: // Siguiente contacto
                if (iterator.hasNext()) {
                    iterator.next(); // Mueve el iterador al siguiente
                } else {
                    System.out.println("No hay más contactos.");
                    return false; // Indica que no hay contacto actual
                }
                break;
            case 2: // Contacto anterior
                    iterator.previous(); // Mueve el iterador al anterior
                break;
            case 3: // Editar contacto
                if (iterator.hasNext()) {
                    editarContacto(iterator.peek());
                } else {
                    System.out.println("No hay contacto para editar.");
                }
                break;
            case 4: // Eliminar contacto
                if (iterator.hasNext()) {
                    System.out.println("Eliminando contacto: ");
                    iterator.remove();
                    if (!iterator.hasNext()) {
                        System.out.println("No hay más contactos después de la eliminación.");
                        return false;
                    }
                } else {
                    System.out.println("No hay contacto para eliminar.");
                }
                break;
            case 5: // Añadir contacto
                System.out.println("Añadiendo contacto: ");
                MenuContacto.añadirContacto(contactos);
                break;
            case 6: // Regresar al menú principal
                System.out.println("Regresando al menú principal");
                return false; // Indica que se está regresando
            default:
                System.out.println("Elige una opción correcta.");
        }
        return true; // Indica que hay un contacto actual
    }

    private static void editarContacto(Contacto contacto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Editando contacto: ");
        System.out.println(contacto);

        // Verificar el tipo de contacto
        if (contacto instanceof ContactoPersona) {
            // Menú para ContactoPersona
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

            int opcion = Inputs.pedirInputNumerico();

            switch (opcion) {
                case 1:
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    contacto.setNombre(nuevoNombre);
                    break;
                case 2:
                    System.out.print("Nuevo apellido: ");
                    String nuevoApellido = scanner.nextLine();
                    contacto.setApellido(nuevoApellido);
                    break;
                case 3:
                    System.out.print("Nueva dirección: ");
                    String nuevaDireccion = scanner.nextLine();
                    System.out.println("Ingresa el link de la nueva dirección");
                    String linkNuevaDireccion = scanner.nextLine();
                    Direccion nuevaDireccionFinal = new Direccion(nuevaDireccion, linkNuevaDireccion);
                    contacto.setDireccion(nuevaDireccionFinal);
                    break;
                case 4:
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
                    break;
                case 5:
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
                    break;
                case 6:
                    System.out.print("Nueva fecha de nacimiento (formato: dd/mm/yyyy): ");
                    String fechaNacimiento = scanner.nextLine();
                    ((ContactoPersona) contacto).setFechaNacimiento(fechaNacimiento);
                    break;
                case 7:
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
                    break;
                case 8:
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
                    break;
                case 9:
                    System.out.print("Nuevo tipo de relación: ");
                    String nuevoTipoRelacion = scanner.nextLine();
                    ((ContactoPersona) contacto).setTipoRelacion(nuevoTipoRelacion);
                    break;
                case 10:
                    System.out.println("Cancelando edición.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } else if (contacto instanceof ContactoEmpresa) {
            // Menú para ContactoEmpresa
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

            int opcion = Inputs.pedirInputNumerico();

            switch (opcion) {
                case 1:
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    contacto.setNombre(nuevoNombre);
                    break;
                case 2:
                    System.out.print("Nuevo apellido: ");
                    String nuevoApellido = scanner.nextLine();
                    contacto.setApellido(nuevoApellido);
                    break;
                case 3:
                    System.out.print("Nueva dirección: ");
                    String nuevaDireccion = scanner.nextLine();
                    System.out.println("Ingresa el link de la nueva dirección");
                    String linkNuevaDireccion = scanner.nextLine();
                    Direccion nuevaDireccionFinal = new Direccion(nuevaDireccion, linkNuevaDireccion);
                    contacto.setDireccion(nuevaDireccionFinal);
                    break;
                case 4:
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
                    break;
                case 5:
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
                    break;
                case 6:
                    System.out.print("Nuevo nombre de empresa: ");
                    String nuevoNombreEmpresa = scanner.nextLine();
                    ((ContactoEmpresa) contacto).setNombreEmpresa(nuevoNombreEmpresa);
                    break;
                case 7:
                    System.out.print("Nuevo cargo: ");
                    String nuevoCargo = scanner.nextLine();
                    ((ContactoEmpresa) contacto).setCargo(nuevoCargo);
                    break;
                case 8:
                    System.out.print("Nuevo país de residencia: ");
                    String nuevoPais = scanner.nextLine();
                    ((ContactoEmpresa) contacto).setPaisResidencia(nuevoPais);
                    break;
                case 9:
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
                    break;
                case 10:
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
                    break;
                case 11:
                    System.out.println("Cancelando edición.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } else {
            System.out.println("Tipo de contacto no reconocido.");
        }

        System.out.println("Contacto actualizado: ");
        System.out.println(contacto);
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
}