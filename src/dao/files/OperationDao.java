package dao.files;

import dao.Idao;
import presentation.model.Client;
import presentation.model.Log;
import presentation.model.TableauDeBord;

import java.io.IOException;
import java.util.List;

public class OperationDao implements Idao<Log,Long> {


    @Override
    public List<Log> findall() {
        return null;
    }

    @Override
    public Log findById(Long id) {
        return null;
    }

    @Override
    public Log save(Log log) {
        return null;
    }

    @Override
    public List<Client> saveAll(List<Log> liste) {
        return null;
    }

    @Override
    public Log update(Log log) throws IOException {
        return null;
    }

    @Override
    public Boolean delete(Log log) throws IOException {
        return null;
    }

    @Override
    public Boolean deleteById(Long idClient) throws IOException {
        return null;
    }
}
