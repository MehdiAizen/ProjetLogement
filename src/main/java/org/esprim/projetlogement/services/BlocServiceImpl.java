package org.esprim.projetlogement.services;

import org.esprim.projetlogement.entity.Bloc;
import org.esprim.projetlogement.repository.BlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlocServiceImpl implements IBlocService {

    private final BlocRepository blocRepository;

    @Autowired
    public BlocServiceImpl(BlocRepository blocRepository) {
        this.blocRepository = blocRepository;
    }

    @Override
    public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc getBlocById(Long id) {
        return blocRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bloc not found with id: " + id));
    }

    @Override
    public Bloc saveBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBlocById(Long id) {
        if (!blocRepository.existsById(id)) {
            throw new RuntimeException("Bloc not found with id: " + id);
        }
        blocRepository.deleteById(id);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        if (bloc.getIdBloc() == null || !blocRepository.existsById(bloc.getIdBloc())) {
            throw new RuntimeException("Cannot update: Bloc not found");
        }
        return blocRepository.save(bloc);
    }
}