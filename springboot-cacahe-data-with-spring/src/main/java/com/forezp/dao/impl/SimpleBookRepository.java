package com.forezp.dao.impl;

import com.forezp.dao.BookRepository;
import com.forezp.entity.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by fangzhipeng on 2017/4/19.
 */
@Component
public class SimpleBookRepository implements BookRepository {

    /**
     *@Cacheable 在方法执行前 Spring 先查看缓存中是否有数据，如果有数据，则直接返回缓存数据；
     * 若没有数据，调用方法并将方法返回值放进缓存。有两个重要的值， value，返回的内容将存储在 value 定义的缓存的名字对象中。
     * key，如果不指定将使用默认的 KeyGenerator 生成。
     * @CachePut 与 @Cacheable 类似，但是它无论什么情况，都会将方法的返回值放到缓存中, 主要用于数据新增和修改方法。
     * @CacheEvict 将一条或多条数据从缓存中删除, 主要用于删除方法，用来从缓存中移除相应数据。
     */
    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}