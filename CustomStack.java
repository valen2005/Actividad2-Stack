/**
 * Implementación manual de una estructura de pila (Stack) genérica.
 * Limita el tamaño de la pila a MAX_SIZE.
 */
public class CustomStack<T> {
    private static final int MAX_SIZE = 100;
    private Object[] elements;
    private int top;

    /**
     * Constructor para CustomStack.
     * Inicializa el array de elementos y el puntero 'top'.
     */
    public CustomStack() {
        elements = new Object[MAX_SIZE];
        top = -1;
    }

    /**
     * Agrega un elemento a la cima de la pila.
     * @param item El elemento a agregar.
     * @throws IllegalStateException si la pila está llena.
     */
    public void push(T item) {
        if (top == MAX_SIZE - 1) {
            throw new IllegalStateException("Stack is full");
        }
        elements[++top] = item;
    }

    /**
     * Elimina y devuelve el elemento de la cima de la pila.
     * @return El elemento de la cima de la pila.
     * @throws IllegalStateException si la pila está vacía.
     */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) elements[top--];
    }

    /**
     * Devuelve el elemento de la cima de la pila sin eliminarlo.
     * @return El elemento de la cima de la pila.
     * @throws IllegalStateException si la pila está vacía.
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) elements[top];
    }

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Devuelve el número de elementos en la pila.
     * @return El tamaño actual de la pila.
     */
    public int size() {
        return top + 1;
    }
}

