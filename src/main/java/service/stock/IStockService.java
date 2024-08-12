package service.stock;

import model.Stock;

import java.util.List;

public interface IStockService {
    public List<Stock> getAllStocks();
    public Stock getStockById(Long id);
    public Stock addStock(Stock stock);
    public Stock updateStock(Stock stock);
    public Stock deleteStock(Long id);

}
