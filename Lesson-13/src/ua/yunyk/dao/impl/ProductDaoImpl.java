package ua.yunyk.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import ua.yunyk.dao.ProductDao;
import ua.yunyk.domain.Product;
import ua.yunyk.shared.FactoryManager;

public class ProductDaoImpl implements ProductDao {

	EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Product create(Product product) {
		try {
			em.getTransaction().begin();
			em.persist(product);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
		}
		return product;
	}

	@Override
	public Product read(Integer id) {
		Product product = null;
		try {
			product = em.find(Product.class, id);
		} catch (Exception e) {
			System.err.println(e);
		}
		return product;
	}

	@Override
	public Product update(Product product) {
		try {
			// TODO: to be implemented
		} catch (Exception e) {
			System.err.println(e);
		}
		return product;
	}

	@Override
	public void delete(Integer id) {
		try {
			// TODO: to be implemented
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> readAll() {
		List<Product> productRecords = new ArrayList<Product>();
		try {
			Query query = em.createQuery("SELECT e FROM Product e");
			productRecords = query.getResultList();
		} catch (Exception e) {
			System.err.println(e);
		}
		return productRecords;
	}

}
