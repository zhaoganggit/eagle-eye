package org.zhaogang.eagleeye.dao;

import com.googlecode.gentyref.GenericTypeReflector;
import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Joy.wang on 16-5-23.
 */
public class MongoBaseDao<T>   {

    protected MongoTemplate mongoTemplate;
    protected final Class<T> entityClass;

    public MongoBaseDao() {
        super();
        entityClass = getEntityClassUsingReflection();
    }

    public MongoBaseDao(MongoTemplate mongoTemplate) {
        super();
        this.mongoTemplate = mongoTemplate;
        this.entityClass = getEntityClassUsingReflection();
    }

    public MongoBaseDao(Class<T> entityClass, MongoTemplate mongoTemplate) {
        super();
        this.mongoTemplate = mongoTemplate;
        this.entityClass = entityClass;
    }

    private Class<T> getEntityClassUsingReflection() {
        ParameterizedType type = (ParameterizedType) GenericTypeReflector.getExactSuperType(getClass(), MongoBaseDao.class);
        java.lang.reflect.Type typeOfSystemObject = type.getActualTypeArguments()[0];
        return (Class) GenericTypeReflector.erase(typeOfSystemObject);
    }

    public void insert(Object objectToSave) {
        mongoTemplate.insert(objectToSave);
    }
    //TODO this should probably be protected
    public T findOne(Query query) {
        return mongoTemplate.findOne(query, entityClass);
    }

    //TODO this should probably be protected
    public List<T> find(Query query) {
        return mongoTemplate.find(query, entityClass);
    }

    public T findById(Object id) {
        return mongoTemplate.findById(id, entityClass);
    }

    //TODO this should probably be protected
    public T findAndModify(Query query, Update update) {
        return mongoTemplate.findAndModify(query, update, entityClass);
    }

    //TODO this should probably be protected
    public T findAndRemove(Query query) {
        return mongoTemplate.findAndRemove(query, entityClass);
    }

    //TODO this should probably be protected
    public long count(Query query) {
        return mongoTemplate.count(query, entityClass);
    }

    //TODO this should probably be protected
    public WriteResult upsert(Query query, Update update) {
        return mongoTemplate.upsert(query, update, entityClass);
    }

    //TODO this should probably be protected
    public WriteResult updateFirst(Query query, Update update) {
        return mongoTemplate.updateFirst(query, update, entityClass);
    }

    //TODO this should probably be protected
    public WriteResult updateMulti(Query query, Update update) {
        return mongoTemplate.updateMulti(query, update, entityClass);
    }

    //TODO this should probably be protected
    public WriteResult remove(Query query) {
        return mongoTemplate.remove(query, entityClass);
    }

    //TODO this should probably be protected
    public List<T> findAllAndRemove(Query query) {
        return mongoTemplate.findAllAndRemove(query, entityClass);
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    //TODO this should probably be protected
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    //TODO this should probably be protected
    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }
}
