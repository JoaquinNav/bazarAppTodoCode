package service.stock;

import model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import repository.StockRepository;

import java.util.List;

public class StockService implements IStockService {
    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public Stock addStock(Stock stock) {
        //TODO Validate atributes
        return (stock.getIdStock() == null || !stockRepository.existsById(stock.getIdStock()))
                ? stockRepository.save(stock)
                : null;
    }

    @Override
    public Stock updateStock(Stock stock) {
        Stock oldStock = stockRepository.findById(stock.getIdStock()).orElse(null);
        return (oldStock != null) ? stockRepository.save(oldStock) : null;
    }

    @Override
    public Stock deleteStock(Long id) {
        Stock oldStock = stockRepository.findById(id).orElse(null);
        if (oldStock != null) {
            stockRepository.delete(oldStock);
        }
        return oldStock;
    }
}
