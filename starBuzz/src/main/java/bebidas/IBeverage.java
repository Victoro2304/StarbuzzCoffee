package bebidas;

/**
 * Esta interfaz nos permite declarar los métodos que serán necesarios para
 * poder crear una bebida.
 *
 * @author Víctor Humberto Encinas Guzmán 00000244821
 */
public interface IBeverage {

    /**
     * Método que permite obtener la descripción de la bebida.
     *
     * @return cadena con la descripción.
     */
    public String getDescripcion();

    /**
     * Método que permite obtener el costo de la bebida.
     *
     * @return costo de la bebida.
     */
    public float getCosto();
}
