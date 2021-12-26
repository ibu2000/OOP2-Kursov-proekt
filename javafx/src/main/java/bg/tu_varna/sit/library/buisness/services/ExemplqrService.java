package bg.tu_varna.sit.library.buisness.services;

import bg.tu_varna.sit.library.data.repositories.EksemplqriRepository;
import bg.tu_varna.sit.library.data.repositories.StateOfBooksRepository;

public class ExemplqrService {

    private final EksemplqriRepository repositoryStateOfBooks = EksemplqriRepository.getInstance();

    public static ExemplqrService getInstance() {return ExemplqrService.ExemplqrServiceHolder.INSTANCE;}

    private static class  ExemplqrServiceHolder
    {
        public static final  ExemplqrService INSTANCE = new  ExemplqrService();
    }



}
