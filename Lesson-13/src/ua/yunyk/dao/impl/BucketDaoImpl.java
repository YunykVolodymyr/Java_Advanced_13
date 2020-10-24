package ua.yunyk.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ua.yunyk.dao.BucketDao;
import ua.yunyk.domain.Bucket;
import ua.yunyk.shared.FactoryManager;

public class BucketDaoImpl implements BucketDao {

	EntityManager em = FactoryManager.getEntityManager();

	
	@Override
	public Bucket create(Bucket bucket) {
		try {
			em.getTransaction().begin();
			em.persist(bucket);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
		}
		return bucket;
	}

	@Override
	public Bucket read(Integer id) {
		Bucket bucket = null;
		try {
			bucket = em.find(Bucket.class, id);
		} catch (Exception e) {
			System.err.println(e);
		}
		return bucket;
	}

	@Override
	public Bucket update(Bucket bucket) {
		throw new IllegalStateException("There is no update for Bucket");
	}

	@Override
	public void delete(Integer id) {
		try {
			Bucket bucket = read(id);
			em.getTransaction().begin();
			em.remove(bucket);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bucket> readAll() {
		List<Bucket> bucketRecords = new ArrayList<Bucket>();
		try {
			Query query = em.createQuery("SELECT e FROM Bucket e");
			bucketRecords = query.getResultList();
		} catch (Exception e) {
			System.err.println(e);
		}
		return bucketRecords;
	}


}
