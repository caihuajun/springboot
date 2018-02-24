package com.forezp.dao;


import com.forezp.entity.Book;

/**
 * Created by fangzhipeng on 2017/4/19.
 */
public interface BookRepository {
    Book getByIsbn(String isbn);
}
