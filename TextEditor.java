import java.util.Scanner;

/**
 * Simulador de editor de texto simple con funcionalidad de deshacer/rehacer (Undo/Redo).
 * Utiliza dos pilas (CustomStack) para gestionar el historial de acciones.
 */
public class TextEditor {
    private CustomStack<String> undoStack; // Pila para almacenar los estados del texto para deshacer
    private CustomStack<String> redoStack; // Pila para almacenar los estados deshechos para rehacer
    private StringBuilder currentText;     // El estado actual del texto en el editor

    /**
     * Constructor para TextEditor.
     * Inicializa las pilas de deshacer y rehacer, y el texto actual.
     * El estado inicial (cadena vacía) se añade a la pila de deshacer.
     */
    public TextEditor() {
        undoStack = new CustomStack<>();
        redoStack = new CustomStack<>();
        currentText = new StringBuilder();
        undoStack.push(""); // Estado inicial vacío
    }

    /**
     * Añade texto al editor y guarda el nuevo estado en la pila de deshacer.
     * La pila de rehacer se vacía al realizar una nueva acción.
     * @param text El texto a añadir.
     */
    public void writeText(String text) {
        currentText.append(text);
        undoStack.push(currentText.toString());
        redoStack = new CustomStack<>(); // Limpiar la pila de rehacer en una nueva acción
    }

    /**
     * Deshace la última acción realizada, restaurando el estado anterior del texto.
     * El estado deshecho se mueve a la pila de rehacer.
     */
    public void undo() {
        if (undoStack.size() > 1) { // Asegurarse de que siempre haya al menos un estado (el actual)
            String undoneState = undoStack.pop();
            redoStack.push(undoneState);
            currentText = new StringBuilder(undoStack.peek());
            System.out.println("Acción deshecha.");
        } else {
            System.out.println("No hay más acciones para deshacer.");
        }
    }

    /**
     * Rehace la última acción deshecha, restaurando el estado que fue deshecho.
     * El estado rehecho se mueve de nuevo a la pila de deshacer.
     */
    public void redo() {
        if (!redoStack.isEmpty()) {
            String redoneState = redoStack.pop();
            undoStack.push(redoneState);
            currentText = new StringBuilder(redoneState);
            System.out.println("Acción rehecha.");
        } else {
            System.out.println("No hay más acciones para rehacer.");
        }
    }

    /**
     * Obtiene el texto actual del editor.
     * @return El texto actual como String.
     */
    public String getCurrentText() {
        return currentText.toString();
    }

    /**
     * Muestra el menú de opciones del editor en la consola.
     */
    public void displayMenu() {
        System.out.println("\n--- Editor de Texto Simple ---");
        System.out.println("1. Escribir texto");
        System.out.println("2. Deshacer (Undo)");
        System.out.println("3. Rehacer (Redo)");
        System.out.println("4. Mostrar texto actual");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Método principal para ejecutar el editor de texto.
     * Permite al usuario interactuar con el editor a través de un menú de consola.
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            editor.displayMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (option) {
                case 1:
                    System.out.print("Ingrese el texto a añadir: ");
                    String text = scanner.nextLine();
                    editor.writeText(text);
                    System.out.println("Texto actual: " + editor.getCurrentText());
                    break;
                case 2:
                    editor.undo();
                    System.out.println("Texto actual: " + editor.getCurrentText());
                    break;
                case 3:
                    editor.redo();
                    System.out.println("Texto actual: " + editor.getCurrentText());
                    break;
                case 4:
                    System.out.println("Texto actual: " + editor.getCurrentText());
                    break;
                case 5:
                    System.out.println("Saliendo del editor.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 5);

        scanner.close();
    }
}


