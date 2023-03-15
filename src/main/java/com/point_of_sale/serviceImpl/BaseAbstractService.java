package com.point_of_sale.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseAbstractService<Entity> {
	@Autowired
	protected ModelMapper modelMapper;

	private JpaRepository<Entity, Long> jpaRepository;

	public BaseAbstractService(JpaRepository<Entity, Long> jpaRepository) {
		this.jpaRepository = jpaRepository;
	}

	public List<Entity> findAll() throws Exception {
		try {
			return jpaRepository.findAll();
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public List<Entity> findAll(Sort sort) throws Exception {
		try {
			return jpaRepository.findAll(sort);
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public List<Entity> findAllById(Iterable<Long> ids) throws Exception {
		try {
			return jpaRepository.findAllById(ids);
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public List<Entity> saveAll(Iterable<Entity> entities) throws Exception {
		try {
			return jpaRepository.saveAll(entities);
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public void flush() throws Exception {
		try {
			jpaRepository.flush();
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public Entity saveAndFlush(Entity entity) throws Exception {
		try {
			return jpaRepository.saveAndFlush(entity);
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public void deleteInBatch(Iterable<Entity> entities) throws Exception {
		try {
			jpaRepository.deleteInBatch(entities);
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public void deleteAllInBatch() throws Exception {
		try {
			jpaRepository.deleteAllInBatch();
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public Entity getOne(Long id) throws Exception {
		try {
			return jpaRepository.getOne(id);
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public List<Entity> findAll(Entity example) throws Exception {
		try {
			ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues();
			return jpaRepository.findAll(Example.of(example, matcher));
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public List<Entity> findAll(Entity example, Sort sort) throws Exception {
		try {
			ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues();
			return jpaRepository.findAll(Example.of(example, matcher), sort);
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public Page<Entity> findAll(Pageable pageable) throws Exception {
		try {
			return jpaRepository.findAll(pageable);
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public Entity save(Entity entity) throws Exception {
		try {
			return jpaRepository.save(entity);
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public Entity findById(Long id) throws Exception {
		try {
			return jpaRepository.findById(id).orElse(null);
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public boolean existsById(Long id) throws Exception {
		try {
			return jpaRepository.existsById(id);
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public long count() throws Exception {
		try {
			return jpaRepository.count();
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public void deleteById(Long id) throws Exception {
		try {
			jpaRepository.deleteById(id);
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public void delete(Entity entity) throws Exception {
		try {
			jpaRepository.delete(entity);
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public void deleteAll(Iterable<Entity> entities) throws Exception {
		try {
			jpaRepository.deleteAll(entities);
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public void deleteAll() throws Exception {
		try {
			jpaRepository.deleteAll();
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public Entity findOne(Entity example) throws Exception {
		try {
			ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues();
			return jpaRepository.findOne(Example.of(example, matcher)).orElse(null);
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public Page<Entity> findAll(Entity example, Pageable pageable) throws Exception {
		try {
			ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues();
			return jpaRepository.findAll(Example.of(example, matcher), pageable);
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public long count(Entity example) throws Exception {
		try {
			ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues();
			return jpaRepository.count(Example.of(example, matcher));
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

	public boolean exists(Entity example) throws Exception {
		try {
			ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues();
			return jpaRepository.exists(Example.of(example, matcher));
		} catch (Exception thr) {
			throw new Exception(thr.getMessage());
		}
	}

}
