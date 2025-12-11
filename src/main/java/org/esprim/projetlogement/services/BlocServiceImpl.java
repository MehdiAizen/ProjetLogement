package org.esprim.projetlogement.services;

import lombok.extern.slf4j.Slf4j;
import org.esprim.projetlogement.entity.Bloc;
import org.esprim.projetlogement.entity.Chambre;
import org.esprim.projetlogement.repository.BlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class BlocServiceImpl implements IBlocService {

    private final BlocRepository blocRepository;

    @Autowired
    public BlocServiceImpl(BlocRepository blocRepository) {
        this.blocRepository = blocRepository;
    }

    @Override
    public List<Bloc> getAllBlocs() {
        return blocRepository.findAllWithChambres();
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

    // --------------------------------------------
    // SERVICE DEMANDÉ DANS LE SUJET
    // --------------------------------------------

    @Scheduled(fixedRate = 60000) // s'exécute toutes les minutes
    public void listeChambres() {
        List<Bloc> blocs = blocRepository.findAllWithChambres();

        for (Bloc bloc : blocs) {
            log.info("Bloc => " + bloc.getNomBloc()
                    + " ayant une capacité " + bloc.getCapaciteBloc());

            Set<Chambre> chambres = bloc.getChambres();

            if (chambres == null || chambres.isEmpty()) {
                log.info("Pas de chambre disponible dans ce bloc");
                log.info("*****************************");
                continue;
            }

            log.info("La liste des chambres pour ce bloc:");

            for (Chambre chambre : chambres) {
                log.info("NumChambre: " + chambre.getNumeroChambre()
                        + " type: " + chambre.getTypeChambre());
            }

            log.info("*****************************");
        }
    }
}