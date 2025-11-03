package org.esprim.projetlogement.services;

import org.esprim.projetlogement.entity.Bloc;
import java.util.List;

public interface IBlocService {
    List<Bloc> getAllBlocs();
    Bloc getBlocById(Long id);
    Bloc saveBloc(Bloc bloc);
    void deleteBlocById(Long id);
    Bloc updateBloc(Bloc bloc);
}