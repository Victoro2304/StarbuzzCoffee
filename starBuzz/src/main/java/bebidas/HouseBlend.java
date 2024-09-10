package bebidas;

/**
 * Esta clase nos permite asignar la implementación a los métodos de la interfaz
 * según los valores de la bebida House Blend.
 *
 * @author Víctor Humberto Encinas Guzmán 00000244821
 */
public class HouseBlend implements IBeverage {

    /**
     * Permite obtener la descripción de la bebida ordenada.
     *
     * @return descripción de la bebida.
     */
    @Override
    public String getDescripcion() {
        return "House Blend";
    }

    /**
     * Permite obtener el costo de la bebida ordenada.
     *
     * @return costo de la bebida.
     */
    @Override
    public float getCosto() {
        return 38.0f;
    }

}
