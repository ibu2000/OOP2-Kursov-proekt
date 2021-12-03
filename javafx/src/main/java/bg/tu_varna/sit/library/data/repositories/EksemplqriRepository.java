package bg.tu_varna.sit.library.data.repositories;

import bg.tu_varna.sit.library.data.entities.Eksemplqri;
import bg.tu_varna.sit.library.data.entities.LENDINFO;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class EksemplqriRepository implements DAORepository<Eksemplqri> {
    private static final Logger log = Logger.getLogger(EksemplqriRepository.class);

    private static EksemplqriRepository getInstance() {return EksemplqriRepository.EksemplqriRepositoryHolder.INSTANCE;}

    private static class EksemplqriRepositoryHolder {
        public static final EksemplqriRepository INSTANCE =new EksemplqriRepository() ;
    }

    @Override
    public void save(Eksemplqri obj) {

    }

    @Override
    public void update(Eksemplqri obj) {

    }

    @Override
    public void delete(Eksemplqri obj) {

    }

    @Override
    public Optional<Eksemplqri> getByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Eksemplqri> getAll() {
        return null;
    }
}