package dao;

import presentation.model.Client;

import java.io.IOException;
import java.util.List;

public interface Idao<T,ID> {
    List<T> findall();
    T findById(Long id);

    T save(T t);
    List<Client> saveAll(List<T> liste);
    T update(T t) throws IOException;
    Boolean delete(T t) throws IOException;
    Boolean deleteById(Long idClient) throws IOException;



}

