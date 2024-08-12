package service.product;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product addProduct(Product product) {
        //TODO validate product atributes with a Class Validator
        //TODO Validate unique id
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        //TODO Validate product atributes before to update
        if(productRepository.existsById(product.getIdProduct())) {
            return productRepository.save(product);
        }
        //TODO Gestionar Errores
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        if(productRepository.existsById(id)) {
            Product product = productRepository.findById(id).orElse(null);
            productRepository.delete(product);
            return product;
        }
        //TODO Gestionar Errores
        return null;
    }
}
