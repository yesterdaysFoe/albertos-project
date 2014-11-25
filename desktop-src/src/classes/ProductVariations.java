/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import controllers.Wp1PostsJpaController;

/**
 *
 * @author David Daniel Kurtz <daviddanielkurtz@gmail.com>
 */
public class ProductVariations {

    private String id;
    private String name;
    private String parrentProduct;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        Wp1PostsJpaController controller = new Wp1PostsJpaController(config.Config.getInstance());
        return (String) controller.findVariationName(Long.parseLong(getId()));
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParrentProduct() {
        return parrentProduct;
    }

    public void setParrentProduct(String parrentProduct) {
        this.parrentProduct = parrentProduct;
    }

    @Override
    public String toString() {
        return getName();
    }
}
