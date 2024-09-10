package condimentos;

import bebidas.IBeverage;

/**
 * Esta clase abstracta nos permite asignar la implementación a los métodos de
 * la interfaz según los valores de los condimentos. Esta clase nos permite
 * tener una estructura clara para que los condimentos decoren al objeto bebida.
 *
 * @author Víctor Humberto Encinas Guzmán 00000244821
 */
public abstract class CondimentDecorator implements IBeverage {

    protected IBeverage beverage;

    /**
     * Constructor que nos permite recibir la bebida que queremos envolver con
     * los condimentos.
     *
     * @param beverage bebida seleccionada
     */
    public CondimentDecorator(IBeverage beverage) {
        this.beverage = beverage;
    }

    /**
     * Permite obtener la descripción de la bebida ordenada.
     *
     * @return descripción de la bebida.
     */
    @Override
    public String getDescripcion() {
        return beverage.getDescripcion();
    }

    /**
     * Permite obtener el costo de la bebida ordenada.
     *
     * @return costo de la bebida.
     */
    @Override
    public float getCosto() {
        return beverage.getCosto();
    }

}
