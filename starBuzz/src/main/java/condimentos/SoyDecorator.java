
package condimentos;

import bebidas.IBeverage;

/**
 * Esta clase permite implementar los métodos de la clase padre. Esta clase nos
 * permite envolver el objeto bebida con los datos del condimento Soy.
 *
 * @author Víctor Humberto Encinas Guzmán 00000244821
 */
public class SoyDecorator extends CondimentDecorator{
    
    /**
     * Constructor que recibe el parametro de beverage, esto permite recibir la
     * bebida ordenada para poder envolverla con los datos del condimento.
     *
     * @param beverage bebida ordenada
     */
    public SoyDecorator(IBeverage beverage) {
        super(beverage);
    }
    
    /**
     * Permite obtener la descripción de la bebida ordenada y el condimento
     * seleccionado.
     *
     * @return descripción de la bebida con el complemento.
     */
    @Override
    public String getDescripcion() {
        return beverage.getDescripcion() + ", Soy";
    }

    /**
     * Permite obtener el costo de la bebida ordenada y el condimento
     * seleccionado.
     *
     * @return costo de la bebida con el complemento.
     */
    @Override
    public float getCosto() {
        return beverage.getCosto() + 4.0f;
    }
    
}
